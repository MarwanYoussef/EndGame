package defaultPackage;

import java.util.Collection;

public class EndGame extends genericSearch implements Problem {
	
	static short rows;
	static short columns;
	static short ironx, irony;
	static short thanosx, thanosy;
	
	public EndGame(String grid) {
		getInitialState(grid);
	}
	
	@Override
	public Object getInitialState(String grid) {
		// TODO Auto-generated method stub
		String[] a = grid.split(";");
		String[] dimensions = a[0].split(",");
		String[] ironlocs = a[1].split(",");
		String[] thanoslocs = a[2].split(",");
		String[] stoneslocs = a[3].split(",");
		String[] warriorlocs = a[4].split(",");
		rows = Short.parseShort(dimensions[0]);
		columns = Short.parseShort(dimensions[1]);
		ironx = Short.parseShort(ironlocs[0]);
		irony = Short.parseShort(ironlocs[1]);
		thanosx = Short.parseShort(thanoslocs[0]);
		thanosy = Short.parseShort(thanoslocs[1]);
		return null;
	}

	@Override
	public boolean isGoal(Object state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Object> getActions(Object state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getNextState(Object state, Object action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getStepCost(Object start, Object action, Object dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String searchProblem(Problem problem, String Strategy) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void parser(String grid) {
		String[] a = grid.split(";");
		String[] dimensions = a[0].split(",");
		String[] ironlocs = a[1].split(",");
		String[] thanoslocs = a[2].split(",");
		String[] stoneslocs = a[3].split(",");
		String[] warriorlocs = a[4].split(",");
		rows = Short.parseShort(dimensions[0]);
		columns = Short.parseShort(dimensions[1]);
		ironx = Short.parseShort(ironlocs[0]);
		irony = Short.parseShort(ironlocs[1]);
		thanosx = Short.parseShort(thanoslocs[0]);
		thanosy = Short.parseShort(thanoslocs[1]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parser("5,5;1,2;3,1;0,2,1,1,2,1,2,2,4,0,4,1;0,3,3,0,3,2,3,4,4,3");
	}
}
