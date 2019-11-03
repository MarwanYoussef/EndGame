package defaultPackage;

import java.util.ArrayList;


// This interface is implemented by the EndGame.Java and these
// methods were defined there.
public interface Problem {
	
	public State getInitialState();
    public boolean isGoal(State state);
    public ArrayList<Operators> getActions(State state);
    public State getNextState(State state, Operators action);
    public byte getStepCost(State old_state, State new_state , Operators action);

}
