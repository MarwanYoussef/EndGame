package defaultPackage;

import java.util.ArrayList;
import java.util.Collection;

public interface Problem {
	
	
	public State getInitialState();
    public boolean isGoal(State state);
    public ArrayList<Operators> getActions(State state);
    public State getNextState(State state, Operators action);
    public byte getStepCost(State old_state, State new_state , Operators action);

}
