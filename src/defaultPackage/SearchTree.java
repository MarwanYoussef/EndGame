 package defaultPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.HashMap;

public class SearchTree extends genericSearch{

	Vector<Node> Nodes = new Vector<Node>();
	State inState;
	Node inNode;
	Problem problem;
	HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
	int expanded = 0;
	boolean hur_flag = false;
	
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
		int lvl = 0 ;
		while(!Nodes.isEmpty()) {
			Node front_node = Nodes.remove(0);
			if(problem.isGoal(front_node.getState())) 
				return front_node;
			else {
				switch(strategy) {
					case("BF"): BFS(Nodes, expand(front_node, problem.getActions(front_node.getState()),strategy));break;
					case("DF"): DFS(Nodes, expand(front_node, problem.getActions(front_node.getState()),strategy));break;
					case("ID"): ID(Nodes, expand(front_node, problem.getActions(front_node.getState()),strategy), lvl,inNode);
								if(Nodes.isEmpty())
								{
									lvl++;
									Nodes.add(inNode);
									hashmap.clear();
								}
								break;
					case("UC"): UC(Nodes, expand(front_node, problem.getActions(front_node.getState()),strategy));break;
					case("GR1"): GR1(Nodes, expand(front_node, problem.getActions(front_node.getState()),strategy));break;
					case("GR2"): GR2(Nodes, expand(front_node, problem.getActions(front_node.getState()),strategy));break;
					case("AS1"): AS1(Nodes, expand(front_node, problem.getActions(front_node.getState()),strategy));break;
					case("AS2"): AS2(Nodes, expand(front_node, problem.getActions(front_node.getState()),strategy));break;
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


	public Vector<Node> expand(Node node, ArrayList<Operators> operators,String strategy) {
		expanded++;
		Vector<Node> new_nodes = new Vector<Node>();
		
		for (Operators operator : operators) {
			State new_state = problem.getNextState(node.getState(), operator);
			byte stepCost = problem.getStepCost(node.getState(), new_state, operator);
			
			if(stepCost+node.getPathCost()<100) {
			
				Node parent = node;
				
				String state_string = new_state.toString();
				
				int code = state_string.hashCode();
				if(!hashmap.containsKey(code)) {
					int hur=0;
					switch(strategy) {
					case("BF"): hur=0;break;
					case("DF"): hur=0;break;
					case("ID"):hur=0;break;
					case("UC"): hur=0;break;
					case("GR1"): hur=huristic_1(new_state);break;
					case("GR2"): hur=huristic_2(new_state);break;
					case("AS1"): hur=(int) (huristic_1(new_state)+node.getPathCost()+stepCost);break;
					case("AS2"): hur=(int) (huristic_2(new_state)+node.getPathCost()+stepCost);break;
					
					}
					hashmap.put(code, state_string);
					Node new_node = new Node(new_state, parent, operator, stepCost, node.getDepth()+1,hur);
					new_nodes.add(new_node);
					
					System.out.print(operator.toString()+" ");
				}
				
			}
		}
		System.out.println();
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
	
	public Vector<Node> ID(Vector<Node> nodes, Vector<Node> new_nodes, int lvl,Node initial){

		for (Node node : new_nodes) {
			if(node.getDepth() <= lvl)
			{
				nodes.add(0,node);
			}
		}
		return nodes;
	}
	
	public Vector<Node> UC(Vector<Node> nodes, Vector<Node> new_nodes){
		nodes.addAll(new_nodes);
		Comparator<Node> c = new Comparator<Node>() {
			
			@Override
			public int compare(Node o1, Node o2) {
				
				return (int)o1.getPathCost()-(int)o2.getPathCost();
			}
		};
		
		Collections.sort(nodes, c);
		return nodes;
	}
	
	public Vector<Node> GR1(Vector<Node> nodes, Vector<Node> new_nodes){
		
		nodes.addAll(new_nodes);
		Comparator<Node> c = new Comparator<Node>() {
			
			@Override
			public int compare(Node o1, Node o2) {
				
				return (int)o1.getHur()-(int)o2.getHur();
			}
		};
		
		Collections.sort(nodes, c);
		return nodes;
	}
	
	public Vector<Node> GR2(Vector<Node> nodes, Vector<Node> new_nodes){
		nodes.addAll(new_nodes);
		Comparator<Node> c = new Comparator<Node>() {
			
			@Override
			public int compare(Node o1, Node o2) {
				
				return (int)o1.getHur()-(int)o2.getHur();
			}
		};
		
		Collections.sort(nodes, c);
		return nodes;
		
	}
	
	public Vector<Node> AS1(Vector<Node> nodes, Vector<Node> new_nodes){
		
		nodes.addAll(new_nodes);
		Comparator<Node> c = new Comparator<Node>() {
			
			@Override
			public int compare(Node o1, Node o2) {
				
				return (int)o1.getHur()-(int)o2.getHur();
			}
		};
		
		Collections.sort(nodes, c);
		return nodes;
		
	}
	
	public Vector<Node> AS2(Vector<Node> nodes, Vector<Node> new_nodes){
		
		nodes.addAll(new_nodes);
		Comparator<Node> c = new Comparator<Node>() {
			
			@Override
			public int compare(Node o1, Node o2) {
				
				return (int)o1.getHur()-(int)o2.getHur();
			}
		};
		
		Collections.sort(nodes, c);
		return nodes;
	}
	public int huristic_1(State state)
	{	
		return ((EndGameState)state).getStones().size()*3;
		
	}
	public int huristic_2(State state)
	{	
		EndGameState endgamestate = (EndGameState) state;
		ArrayList<Byte> stones = endgamestate.getStones();
		int count = 0;
		ArrayList<Byte> warr = endgamestate.getWarriors();
		
		for (Byte byte1 : stones) {
			ArrayList<Byte> around = ((EndGame)problem).get_w_around(byte1);
			for (Byte byte2 : around) {
				if(warr.contains(byte2)) count++; 
			}
		}
		return count+((EndGameState)state).getStones().size();
		
	}
	
}
