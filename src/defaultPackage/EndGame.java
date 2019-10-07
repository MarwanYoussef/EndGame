package defaultPackage;

import java.util.Collection;

public class EndGame extends genericSearch implements Problem {
	
	EndGameState state;
	byte[][] grid;
	static byte rows;
	static byte columns;
	static byte thanos;
	
	
	public EndGame(String grid) {
		getInitialState(grid);
	}
	
	public Object getInitialState(String grid) {
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
		this.grid = new byte[rows][columns];
		//-------------------------------
		
		byte thanosx = Byte.parseByte(thanoslocs[0]);
		byte thanosy = Byte.parseByte(thanoslocs[1]);
		this.thanos = encode_position(thanosx, thanosy, columns);
		
		byte irx = Byte.parseByte(ironlocs[0]);
		byte iry = Byte.parseByte(ironlocs[1]);
		state.setIr(encode_position(irx, iry, columns));
		
		
		
		for (int i = 0; i < warriorlocs.length; i+=2) {
			state.getWarriors().add(Byte.parseByte(warriorlocs[i]));
			
			if(i+1 == warriorlocs.length)
				state.getWarriors().add(Byte.parseByte(warriorlocs[i+1]));
			
		}
		
		for (int i = 0; i < stoneslocs.length; i+=2) {
			state.getStones().add(Byte.parseByte(stoneslocs[i]));
			
			if(i+1 == warriorlocs.length)
				state.getStones().add(Byte.parseByte(stoneslocs[i+1]));
			
		}
			
		return null;
	}

	@Override
	public boolean isGoal(State state) {
		return ((EndGameState) state).isSnapped();
	}

	@Override
	public Collection<State> getActions(State state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State getNextState(State state, State action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getStepCost(State start, State action, State dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String searchProblem(Problem problem, String Strategy) {
		// TODO Auto-generated method stub
		return null;
	}

	//------Encode Position------
		public static byte encode_position(byte x, byte y, byte rows) {
			return (byte)((rows*x)+ y-128);
		}
		
		public static byte[] decode_position(byte hash,byte rows) {
			char hash_int = (char) (hash+128);
			int unpair1 = Math.floorDiv(hash_int, rows);
			int unpair2 = hash_int%rows;
			byte[] pair = {(byte) unpair1,(byte) unpair2};
			return pair;
		}

}
