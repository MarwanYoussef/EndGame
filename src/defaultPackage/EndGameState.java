package defaultPackage;

import java.util.ArrayList;

public class EndGameState implements State {
	
	byte ir;
	ArrayList<Byte> warriors = new ArrayList<Byte>();
	ArrayList<Byte> stones = new ArrayList<Byte>();
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

	public byte getIr() {
		return ir;
	}
	public void setIr(byte ir) {
		this.ir = ir;
	}
	public ArrayList<Byte> getWarriors() {
		return warriors;
	}
	public void setWarriors(ArrayList<Byte> warriors) {
		this.warriors = warriors;
	}
	public ArrayList<Byte> getStones() {
		return stones;
	}
	public void setStones(ArrayList<Byte> stones) {
		this.stones = stones;
	}
	public boolean isSnapped() {
		return snapped;
	}
	public void setSnapped(boolean snapped) {
		this.snapped = snapped;
	}
	
	
	@Override
	public String toString() {
		String string_state = "" + getIr() + ";";
		for (Byte stone : stones) {
			string_state += stone + ",";
		}
		string_state += ";";
		
		for (Byte war : warriors) {
			string_state += war + ",";
		}
		
		string_state += ";" + snapped + ";";
		return string_state;
	}
	
}
	
	