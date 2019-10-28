 package defaultPackage;

import java.util.ArrayList;
import java.util.Vector;
import java.util.HashMap;

public class SearchTree extends genericSearch{

	Vector<Node> Nodes = new Vector<Node>();
	State inState;
	Node inNode;
	Problem problem;
	HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
	int expanded = 0;
	
	public SearchTree(Problem problem) {
		this.problem = problem;
	}
	
	@Override
	public Node searchProblem(Problem problem, String strategy) {
		inState = problem.getInitialState();
		
		// string_state for is "IR,S,W,Snapped,Cost"
		
		String string_state = inState.toString() + "0"; 
		System.out.println(string_state);
		inNode = new Node(inState);
		Nodes.add(inNode);
		
		while(!Nodes.isEmpty()) {
			Node front_node = Nodes.remove(0);
			if(problem.isGoal(front_node.getState())) 
				return front_node;
			else {
				switch(strategy) {
					case("BF"): BFS(Nodes, expand(front_node, problem.getActions(front_node.getState())));
					case("DF"): DFS(Nodes, expand(front_node, problem.getActions(front_node.getState())));
					case("ID"): ID(Nodes, expand(front_node, problem.getActions(front_node.getState())));
					case("UC"): UC(Nodes, expand(front_node, problem.getActions(front_node.getState())));
					case("GR1"): GR1(Nodes, expand(front_node, problem.getActions(front_node.getState())));
					case("GR2"): GR2(Nodes, expand(front_node, problem.getActions(front_node.getState())));
					case("AS1"): AS1(Nodes, expand(front_node, problem.getActions(front_node.getState())));
					case("AS2"): AS2(Nodes, expand(front_node, problem.getActions(front_node.getState())));
				}
					
			}
		}
			
		
		
		
		
		//switch(strategy)
		return null;
	}
	
		
//	function GENERAL-SEARCH(problem, QING-FUN)
//	returns a solution, or failure
//	nodes ←− MAKE-Q(MAKE-NODE(INIT-STATE(problem)))
//	loop do
//	If nodes is empty then return failure
//	node ←− REMOVE-FRONT(nodes)
//	If GOAL-TEST(problem)(STATE(node)) then return node
//	nodes ←− QING-FUN(nodes, EXPAND(node, OPER(problem)))
//	end
	
	
	public int getExpanded() {
		return expanded;
	}


	public Vector<Node> expand(Node node, ArrayList<Operators> operators) {
		expanded++;
		Vector<Node> new_nodes = new Vector<Node>();
		
		for (Operators operator : operators) {
			State new_state = problem.getNextState(node.getState(), operator);
			byte stepCost = problem.getStepCost(new_state, operator);
			
			if(stepCost+node.getPathCost()<100) {
			
				Node parent = node;
				
				String state_string = new_state.toString() + (stepCost+node.getPathCost());
				
				int code = state_string.hashCode();
				if(!hashmap.containsKey(code)) {
					hashmap.put(code, state_string);
					Node new_node = new Node(new_state, parent, operator, stepCost, node.getDepth()+1);
					new_nodes.add(new_node);
				}
				
			}
		}
		return new_nodes;
	}

	public Vector<Node> BFS(Vector<Node> nodes, Vector<Node> new_nodes){
		
		for (Node node : new_nodes) {
			nodes.add(node);
		} 
		return nodes;
	}
	
	public Vector<Node> DFS(Vector<Node> nodes, Vector<Node> new_nodes){
		
		for (Node node : new_nodes) {
			nodes.add(0, node);
		} 
		return nodes;
	}
	
	public Vector<Node> ID(Vector<Node> nodes, Vector<Node> new_nodes){
		return null;
	}
	
	public Vector<Node> UC(Vector<Node> nodes, Vector<Node> new_nodes){
		return null;
	}
	
	public Vector<Node> GR1(Vector<Node> nodes, Vector<Node> new_nodes){
		return null;
	}
	
	public Vector<Node> GR2(Vector<Node> nodes, Vector<Node> new_nodes){
		return null;
	}
	
	public Vector<Node> AS1(Vector<Node> nodes, Vector<Node> new_nodes){
		return null;
	}
	
	public Vector<Node> AS2(Vector<Node> nodes, Vector<Node> new_nodes){
		return null;
	}
	
	
}
