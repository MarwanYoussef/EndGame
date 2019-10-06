package defaultPackage;

import java.util.Collection;

public class EndGame extends genericSearch implements Problem {
	
	EndGameState state;
	char[][] grid;
	static char rows;
	static char columns;
	
	
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
		rows = dimensions[0].charAt(0);
		columns = dimensions[1].charAt(0);
		this.grid = new char[rows][columns];
		//-------------------------------
		
		byte h = Byte.parseByte(dimensions[0]);
				
		
		
//		
//		
//		ironx = Short.parseShort(ironlocs[0]);
//		irony = Short.parseShort(ironlocs[1]);
//		thanosx = Short.parseShort(thanoslocs[0]);
//		thanosy = Short.parseShort(thanoslocs[1]);
//		
//		
//		
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


}
