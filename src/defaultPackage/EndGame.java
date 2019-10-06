package defaultPackage;

import java.util.Collection;

public class EndGame extends genericSearch implements Problem {
	
	static short rows;
	static short columns;
	
	public EndGame(String grid) {
		
	}
	
	@Override
	public Object getInitialState() {
		// TODO Auto-generated method stub
		
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
		int index = 0;
		String[] locs = a[0].split(",");
		rows = Short.parseShort(locs[0]);
		columns = Short.parseShort(locs[1]);
		System.out.println(rows);
		System.out.println(columns);
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parser("5,5;ix,iy;tx,ty;s1,x,s1y,s2x,s2y,s3x,s3y,s4x,s4y,s5x,s5y,s6x,s6y;w1x,w1y,w2x,w2y,w3x,w3y,w4x,w4y,w5x,w5y");
	}
}
