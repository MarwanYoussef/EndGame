package defaultPackage;

public class EndGameState implements State {
	
	static short rows;
	static short columns;
	static char[] ir = new char[2];
	static char[] thanos = new char[2];
	static char[][] warriors;
	static char[][] stones = new char[6][2];
	char damage;
	boolean snapped = false;
	
	
	public static short getRows() {
		return rows;
	}
	public static void setRows(short rows) {
		EndGameState.rows = rows;
	}
	public static short getColumns() {
		return columns;
	}
	public static void setColumns(short columns) {
		EndGameState.columns = columns;
	}
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
	
	public static void parser(String grid) {
		String[] a = grid.split(";");
		int index = 0;
		String[] locs = a[0].split(",");
		rows = Short.parseShort(locs[0]);
		columns = Short.parseShort(locs[1]);
		System.out.println(rows);
		System.out.println(columns);
		}
	

}
