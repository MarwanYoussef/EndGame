package defaultPackage;

import java.util.ArrayList;

public class EndGameState implements State {
	
	static byte ir;
	static ArrayList<Byte> warriors;
	static ArrayList<Byte> stones;
	boolean snapped = false;
	
	
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
	
	
	
	
	
}
	
	