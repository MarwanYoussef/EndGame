package defaultPackage;

public class main {
	
	private EndGame e;
	
	// Solve function takes critical inputs to represent our problem and it's parameters
	public static String solve(String grid, String strategy, boolean visualize) {
		EndGame e = new EndGame(grid);
		SearchTree serching = new SearchTree(e);
		Node result = serching.searchProblem(e, "BF");
		
		if(visualize) {
			toString(grid);
		}
		
		String result_string = "";
		if(result == null)
			result_string =  "There is no solution";
		else {
			result_string += result.pathToString() + result.getPathCost() + ";" + serching.getExpanded();
		}
		return result_string;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = solve("5,5;1,2;3,1;0,2,1,1,2,1,2,2,4,0,4,1;0,3,3,0,3,2,3,4,4,3", "BF", false);
		System.out.println(result);
	}
	
	public static void toString(String grid) {
		
	}

}
