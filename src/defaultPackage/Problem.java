package defaultPackage;

import java.util.Collection;

public interface Problem {
	
	
	
	public Object getInitialState();
    public boolean isGoal(State state);
    public Collection<State> getActions(State state);
    public Object getNextState(State state, State action);
    public double getStepCost(State start, State action, State dest);

}
