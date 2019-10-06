package defaultPackage;

public class EndGameState implements State {
	
	static char[] ir = new char[2];
	static char[] thanos = new char[2];
	static char[][] warriors;
	static char[][] stones = new char[6][2];
	char damage = 0;
	boolean snapped = false;
	
	
	public static char[] getIr() {
		return ir;
	}
	public static void setIr(char[] ir) {
		EndGameState.ir = ir;
	}
	public static char[] getThanos() {
		return thanos;
	}
	public static void setThanos(char[] thanos) {
		EndGameState.thanos = thanos;
	}
	public static char[][] getWarriors() {
		return warriors;
	}
	public static void setWarriors(char[][] warriors) {
		EndGameState.warriors = warriors;
	}
	public static char[][] getStones() {
		return stones;
	}
	public static void setStones(char[][] stones) {
		EndGameState.stones = stones;
	}
	public char getDamage() {
		return damage;
	}
	public void setDamage(char damage) {
		this.damage = damage;
	}
	public boolean isSnapped() {
		return snapped;
	}
	public void setSnapped(boolean snapped) {
		this.snapped = snapped;
	}
	
	

}
