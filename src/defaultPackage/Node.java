package defaultPackage;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private State state;
	private Node parent;
	private Enum operator;
	private double pathCost;
	
	public Node(State state) {
		this.state = state;
		this.pathCost = 0.0;
	}
	
	public Node(State state, Node parent, Enum operator, double stepCost) {
		this(state);
		this.parent = parent;
		this.operator = operator;
		this.pathCost = pathCost + stepCost;
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

	public void setOperator(Enum operator) {
		this.operator = operator;
	}

	public double getPathCost() {
		return pathCost;
	}

	public void setPathCost(double pathCost) {
		this.pathCost = pathCost;
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
		return path;
	}
	
	public String toString() {
		return "Parent: " + getParent() + " Operator: " + getOperator() + " state: " + getState() + " Path Cost: " + getPathCost();
	}
	
	public String pathToString() {
		List<Node> nodes = getPathFromRoot();
		for(int i=0; i<nodes.size(); i++) {
			System.out.println("Operator: " + nodes.get(i).getOperator());
			System.out.println("State " + nodes.get(i).getState());
		}
		return "";
	}

}
