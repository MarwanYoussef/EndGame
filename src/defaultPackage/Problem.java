package defaultPackage;

import java.util.Collection;

public interface Problem {
	
	
	public State getInitialState();
    public boolean isGoal(State state);
    public Collection<State> getActions(State state);
    public State getNextState(State state, Operators action);
    public byte getStepCost(State start, Operators action);

}
