package defaultPackage;

import java.util.Collection;

public class EndGame extends genericSearch implements Problem {
	
	EndGameState state;
	
	
	
	public EndGame(String grid) {
		
	}
	
	@Override
	public State getInitialState() {
		// TODO Auto-generated method stub
		
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char x = 3 ; 
		System.out.println(x -2);
	}
}
