 package defaultPackage;

import java.util.Vector;

public class SearchTree extends genericSearch{

	Vector<Node> Nodes;
	State inState;
	Node inNode;
	@Override
	public Node searchProblem(Problem problem, String strategy) {
		inState = problem.getInitialState();
		inNode = new Node(inState);
		Nodes.add(inNode);
		
		while(!Nodes.isEmpty()) {
			Node front_node = Nodes.remove(0);
			if(problem.isGoal(front_node.getState())) 
				return front_node;
			else {
				
			}
		}
			
		
		
		
		
		//switch(strategy)
		return null;
	}
//	
//	function GENERAL-SEARCH(problem, QING-FUN)
//	returns a solution, or failure
//	nodes ←− MAKE-Q(MAKE-NODE(INIT-STATE(problem)))
//	loop do
//	If nodes is empty then return failure
//	node ←− REMOVE-FRONT(nodes)
//	If GOAL-TEST(problem)(STATE(node)) then return node
//	nodes ←− QING-FUN(nodes, EXPAND(node, OPER(problem)))
//	end


}
