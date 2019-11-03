package defaultPackage;

import java.util.ArrayList;
import java.util.List;

// This class represents the Nodes and their attributes
// Since each node represents a state and each node gets expanded
// by applying some operator.

public class Node {
	
	private State state;
	private Node parent;
	private Enum operator;
	private double pathCost;
	private int depth;
	private int hur;
	//private boolean hur_flag;
	
	public Node(State state) {
		this.state = state;
		this.pathCost = 0.0;
		this.depth = 0 ;
		this.parent=null;
	}
	
	public Node(State state, Node parent, Enum operator, byte stepCost, int depth,int hur) {
		this(state);
		this.parent = parent;
		this.operator = operator;
		this.pathCost = parent.pathCost + stepCost;
		this.depth = depth;
		this.hur=hur;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Object getOperator() {
		return operator;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public void setOperator(Enum operator) {
		this.operator = operator;
	}

	public double getPathCost() {
		return pathCost;
	}

	public void setPathCost(double pathCost) {
		this.pathCost = pathCost;
	}
	
	public int getHur() {
		return hur;
	}

	public void setHur(int hur) {
		this.hur = hur;
	}

	
	public boolean isRootNode() {
		return parent == null;
	}
	
	public List<Node> getPathFromRoot(){
		List<Node> path = new ArrayList<Node>();
		Node current = this;
		while(!current.isRootNode()) {
			path.add(0, current);
			current = current.getParent();
		}
		
		path.add(0, current);
		//System.out.println(path);
		return path;
	}
	
	public String toString() {
		return "Parent: " + getParent() + " Operator: " + getOperator() + " state: " + getState() + " Path Cost: " + getPathCost();
	}
	
	public String pathToString() {
		List<Node> nodes = getPathFromRoot();
		String path = "";
		for(int i=1; i<nodes.size(); i++) {
			path += "" + nodes.get(i).getOperator()+",";
		}
		
		path += ";";
		return path;
	}

}
