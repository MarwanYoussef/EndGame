package defaultPackage;

import java.util.ArrayList;

public class EndGameState implements State {
	
	static byte ir;
	static ArrayList<Byte> warriors = new ArrayList<Byte>();
	static ArrayList<Byte> stones = new ArrayList<Byte>();
	boolean snapped = false;
	
	public EndGameState(byte ir, ArrayList<Byte> warriors, ArrayList<Byte> stones) {
		this.ir = ir;
		this.warriors = warriors;
		this.stones = stones;
	}
	
	public EndGameState(byte ir, ArrayList<Byte> warriors, ArrayList<Byte> stones, boolean snapped) {
		this.ir = ir;
		this.warriors = warriors;
		this.stones = stones;
		this.snapped = snapped;
	}
	
	
	public EndGameState() {
		// TODO Auto-generated constructor stub
	}

	public static byte getIr() {
		return ir;
	}
	public static void setIr(byte ir) {
		EndGameState.ir = ir;
	}
	public static ArrayList<Byte> getWarriors() {
		return warriors;
	}
	public static void setWarriors(ArrayList<Byte> warriors) {
		EndGameState.warriors = warriors;
	}
	public static ArrayList<Byte> getStones() {
		return stones;
	}
	public static void setStones(ArrayList<Byte> stones) {
		EndGameState.stones = stones;
	}
	public boolean isSnapped() {
		return snapped;
	}
	public void setSnapped(boolean snapped) {
		this.snapped = snapped;
	}
	
	
	@Override
	public String toString() {
		String string_state = "" + getIr() + ",";
		for (Byte stone : stones) {
			string_state += stone + ";";
		}
		string_state += ",";
		
		for (Byte war : warriors) {
			string_state += war + ";";
		}
		
		string_state += "," + snapped + ",";
		return string_state;
	}
	
}
	
	