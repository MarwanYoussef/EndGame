package defaultPackage;

import java.util.Collection;

public class EndGame extends genericSearch implements Problem {
	
	public EndGame(char xi, char yi, char xt, char yt, char[] w, char[] s) {
		
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

}
