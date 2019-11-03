package defaultPackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EndGame implements Problem {
	
	EndGameState inState = new EndGameState();
	byte[][] grid; 
	static byte rows;
	static byte columns;
	static byte thanos;
	
	
	public EndGame(String grid) {
		// TODO Auto-generated method stub
				String[] a = grid.split(";");
				String[] dimensions = a[0].split(",");
				String[] ironlocs = a[1].split(",");
				String[] thanoslocs = a[2].split(",");
				String[] stoneslocs = a[3].split(",");
				String[] warriorlocs = a[4].split(",");
				
				//Viz
				rows = Byte.parseByte(dimensions[0]);
				columns = Byte.parseByte(dimensions[1]);
				System.out.println("rows :" + rows + " columns : " + columns );
				this.grid = new byte[rows][columns];
				//-------------------------------
				
				byte thanosx = Byte.parseByte(thanoslocs[0]);
				byte thanosy = Byte.parseByte(thanoslocs[1]);
				this.thanos = encode_position(thanosx, thanosy, columns);
				System.out.println("tx :" + thanosx + " ty : " + thanosy );
				byte irx = Byte.parseByte(ironlocs[0]);
				byte iry = Byte.parseByte(ironlocs[1]);
				System.out.println("irx :" + irx + " iy : " + iry );
				inState.setIr(encode_position(irx, iry, columns));
				
				//System.out.println(inState);
				
				for (int i = 0; i < warriorlocs.length; i+=2) {
					byte index = encode_position(Byte.parseByte(warriorlocs[i]), Byte.parseByte(warriorlocs[i+1]), columns);
					System.out.println("wx :" + warriorlocs[i] + " wy : " + warriorlocs[i+1] );
					inState.getWarriors().add(index);
					
				}
				
				for (int i = 0; i < stoneslocs.length; i+=2) {
					byte index = encode_position(Byte.parseByte(stoneslocs[i]), Byte.parseByte(stoneslocs[i+1]), columns);
					System.out.println("sx :" + stoneslocs[i] + " sy : " + stoneslocs[i+1] );
					inState.getStones().add(index);
					
				}
				System.out.println(inState.getStones().toString());
	}
	
	public State getInitialState() {
		return this.inState;
	}

	@Override
	public boolean isGoal(State state) {
		return ((EndGameState) state).isSnapped();
	}

	@Override
	public ArrayList<Operators> getActions(State state) {
		
		ArrayList<Operators> operators = new ArrayList<Operators>();
		byte[] location = decode_position(((EndGameState) state).getIr(), columns);
		byte new_location_up = encode_position( (byte) (location[0]-1), location[1], columns);
		byte new_location_down = encode_position( (byte) (location[0]+1), location[1], columns);
		byte new_location_left = encode_position(  location[0],  (byte) (location[1]-1), columns);
		byte new_location_right = encode_position(  location[0],  (byte) (location[1]+1), columns);
		
		operators.add(Operators.KILL);
//		System.out.println(location[0] + "    " + location[1] );
//		System.out.println(!checklocs(((EndGameState) state).getWarriors(), new_location_up));
//		System.out.println(check_thanos( ((EndGameState) state).getStones().size(), this.thanos, new_location_up ));
		if(	location[0] != 0 
		&& 	(!checklocs(((EndGameState) state).getWarriors(), new_location_up)) 
		&& check_thanos( ((EndGameState) state).getStones().size(), this.thanos, new_location_up )) 
		{
			operators.add(Operators.UP);
		}
		
		if(	location[0] != rows-1 
		&& 	(!checklocs(((EndGameState) state).getWarriors(), new_location_down)) 
		&& check_thanos( ((EndGameState) state).getStones().size(), this.thanos, new_location_down )) 
		{
			operators.add(Operators.DOWN);
		}
		
		if(	location[1] != 0 
		&& 	(!checklocs(((EndGameState) state).getWarriors(), new_location_left)) 
		&& check_thanos( ((EndGameState) state).getStones().size(), this.thanos, new_location_left )) 
		{
			operators.add(Operators.LEFT);
		}
				
		if(	location[1] != columns-1
		&& 	(!checklocs(((EndGameState) state).getWarriors(), new_location_right)) 
		&& check_thanos( ((EndGameState) state).getStones().size(), this.thanos, new_location_right )) 
		{
			operators.add(Operators.RIGHT);
		}
		
		if(((EndGameState) state).getStones().contains(((EndGameState) state).getIr())) {
			operators.add(Operators.COLLECT);
			
		}
		
		if(((EndGameState) state).getStones().size()==0 || ((EndGameState) state).getIr() == thanos  ) 
			operators.add(Operators.SNAP);

		return operators;
	}

	@Override
	public State getNextState(State state, Operators action) {
		
		
		if(action == Operators.UP) {
			byte[] location = decode_position(((EndGameState) state).getIr(), columns);
			
//			if(location[0] == 0 ) {
//				return state;
//			}

			//new_location = { (byte) (location[0]-1) , location[1] };
			
			byte new_location = encode_position( (byte) (location[0]-1), location[1], columns);
			
		//	if((!checklocs(((EndGameState) state).getWarriors(), new_location)) && check_thanos( ((EndGameState) state).getStones().size(), this.thanos, new_location ) ) {
				EndGameState new_state = new EndGameState(new_location, ((EndGameState) state).getWarriors(), ((EndGameState) state).getStones());
				return new_state;
		//	}
		}
		
		if(action == Operators.DOWN) {
			
				byte[] location = decode_position(((EndGameState) state).getIr(), columns);
				
//				if(location[0] == rows ) {
//					return state;
//				}
//
//				//new_location = { (byte) (location[0]-1) , location[1] };
				
				byte new_location = encode_position( (byte) (location[0]+1), location[1], columns);
				
		//		if((!checklocs(((EndGameState) state).getWarriors(), new_location)) && check_thanos( ((EndGameState) state).getStones().size(), this.thanos, new_location ) ) {
					EndGameState new_state = new EndGameState(new_location, ((EndGameState) state).getWarriors(), ((EndGameState) state).getStones());
					return new_state;
			//	}
			
		}
		
		if(action == Operators.LEFT) {
			
			byte[] location = decode_position(((EndGameState) state).getIr(), columns);
			
//			if(location[1] == 0 ) {
//				return state;
//			}
//
//			//new_location = { (byte) (location[0]-1) , location[1] };
//			
			byte new_location = encode_position(  location[0],  (byte) (location[1]-1), columns);
			
			//if((!checklocs(((EndGameState) state).getWarriors(), new_location)) && check_thanos( ((EndGameState) state).getStones().size(), this.thanos, new_location ) ) {
				EndGameState new_state = new EndGameState(new_location, ((EndGameState) state).getWarriors(), ((EndGameState) state).getStones());
				return new_state;
			//}
			
		}
		
		if(action == Operators.RIGHT) {
			
			byte[] location = decode_position(((EndGameState) state).getIr(), columns);
			
//			if(location[1] == columns ) {
//				return state;
//			}
//
//			//new_location = { (byte) (location[0]-1) , location[1] };
			
			byte new_location = encode_position(  location[0],  (byte) (location[1]+1), columns);
			
//			if((!checklocs(((EndGameState) state).getWarriors(), new_location)) && check_thanos( ((EndGameState) state).getStones().size(), this.thanos, new_location ) ) {
				EndGameState new_state = new EndGameState(new_location, ((EndGameState) state).getWarriors(), ((EndGameState) state).getStones());
				return new_state;
			//}
			
		}
		
		if(action == Operators.COLLECT) {
			if(!((EndGameState) state).getStones().contains(((EndGameState) state).getIr())) {
				return state;
			}
			else {
				ArrayList<Byte> new_stones = new ArrayList<Byte>(((EndGameState) state).getStones());
				new_stones.remove((Object)((EndGameState) state).getIr());
				EndGameState new_state = new EndGameState(((EndGameState) state).getIr() , ((EndGameState) state).getWarriors(), new_stones);
				return new_state;
			}
		}
		
		if(action == Operators.KILL) {
			ArrayList<Byte> new_location = get_w_around( ((EndGameState) state).getIr() );
			ArrayList<Byte> new_warriors = new ArrayList<Byte>(((EndGameState) state).getWarriors());
			
			for (Byte byte1 : new_location) {
				new_warriors.remove(byte1);
			}
			
			if(new_warriors.equals(((EndGameState) state).getWarriors())) return state ;
			
			else { 
				EndGameState new_state = new EndGameState(((EndGameState) state).getIr() , new_warriors, ((EndGameState) state).getStones());
				return new_state;
			}
			
		}
		
		if(action == Operators.SNAP) {
			if(((EndGameState) state).getStones().size()!=0 || ((EndGameState) state).getIr() != thanos  ) return state;
			
			else {
				EndGameState new_state = new EndGameState(((EndGameState) state).getIr() , ((EndGameState) state).getWarriors(), ((EndGameState) state).getStones(), true);
				return new_state;
			}
			
			
		}
		
		return null;
	}

	@Override
	public byte getStepCost(State old_state,State new_state, Operators action) {
		
		byte cost = 0;
		
//		if (action == Operators.UP || action == Operators.DOWN || action == Operators.RIGHT || action == Operators.LEFT) {
//			byte[] location = decode_position(((EndGameState) start).getIr(), columns);
//			byte[] new_location = new byte[2] ;
//			
//		if(action == Operators.UP) {
//				
//				new_location[0] = (byte) (location[0]-1);
//				new_location[1]	= location[1];
//		}
//		
//		if(action == Operators.DOWN) {
//			
//			new_location[0] = (byte) (location[0]+1);
//			new_location[1]	= location[1];
//		}
//		
//		if(action == Operators.LEFT) {
//			
//			new_location[0] = location[0];
//			new_location[1]	= (byte) (location[1]-1);
//		}
//		
//		if(action == Operators.RIGHT) {
//			
//			new_location[0] = location[0];
//			new_location[1]	= (byte) (location[1]+1);
//		}				
				
		ArrayList<Byte> w_around = get_w_around(((EndGameState) new_state).getIr());
			for (byte b : w_around) {
				if(((EndGameState) new_state).getWarriors().contains(b)) 
					cost+=1;
				
				if(b == thanos) cost+=5; 
				
			}
			
		
			if(((EndGameState) new_state).getIr() == thanos) cost+=5;
			
			
		//}
		
		if(action == Operators.COLLECT) {
				cost+=3;
		}
		
		if(action == Operators.KILL) {
			int factor = ((EndGameState) old_state).getWarriors().size()  
					-  	((EndGameState) new_state).getWarriors().size();
			cost+= factor *2;
				
			
		}
		
		
		return cost;
	}


	public static byte getRows() {
		return rows;
	}

	public static void setRows(byte rows) {
		EndGame.rows = rows;
	}

	public static byte getColumns() {
		return columns;
	}

	public static void setColumns(byte columns) {
		EndGame.columns = columns;
	}

	public static byte getThanos() {
		return thanos;
	}

	public static void setThanos(byte thanos) {
		EndGame.thanos = thanos;
	}

		//------Encode Position------
		public static byte encode_position(byte x, byte y, byte length) {
			//System.out.println(x);
			int x_x = (int) x;
			int y_y = (int) y;
			int length_length = (int) length;
			int num = ((length_length*x_x)+ y_y) - 128;
			//System.out.println(num);
			return (byte) num;
					
		}
		
		public static byte[] decode_position(byte hash,byte length) {
			char hash_int = (char) (hash+128);
			int unpair1 = Math.floorDiv(hash_int, length);
			int unpair2 = hash_int%length;
			byte[] pair = {(byte) unpair1,(byte) unpair2};
			return pair;
		}

		public static boolean checklocs(ArrayList<Byte> arrayList, byte loc) {
			boolean contain = false; 
			for (byte w_s : arrayList) {
				if(w_s == loc) {
					contain = true; break;  
				}
			}
			return contain;
		}
		
		
		public boolean check_thanos(int size_stones, byte thanos_loc, byte ir_loc ) {
			if(thanos_loc == ir_loc) { 
				if(size_stones==0) {
					return true;
				}
				else {
					return false;
				}
			}
			return true;
		}
		
		public ArrayList<Byte> get_w_around(byte loc) 
		{
			byte[] location = decode_position(loc, columns);
			ArrayList<Byte> new_locations = new ArrayList<Byte>();
			if (location[1]+1 != columns) {
				byte right = encode_position(  location[0],  (byte) (location[1]+1), columns);
				new_locations.add(right);
			}
			
			if (location[1]-1 != -1) {
				byte left = encode_position(  location[0],  (byte) (location[1]-1), columns);
				new_locations.add(left);
			}
			
			if (location[0]+1 != rows) {
				byte down = encode_position( (byte) (location[0]+1), location[1], columns);
				new_locations.add(down);
			}
			
			if (location[0]-1 != -1) {
				byte up = encode_position( (byte) (location[0]-1), location[1], columns);
				new_locations.add(up);
			}
			
			
			return new_locations;
		}
}
