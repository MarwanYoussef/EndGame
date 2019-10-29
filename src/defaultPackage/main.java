package defaultPackage;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static EndGame e;
	
	// Solve function takes critical inputs to represent our problem and it's parameters
	public static String solve(String grid, String strategy, boolean visualize) {
		EndGame e = new EndGame(grid);
		SearchTree serching = new SearchTree(e);
		Node result = serching.searchProblem(e, strategy);
		
		if(visualize) {
			drawGrid(result.getPathFromRoot());
		}
		
		String result_string = "";
		if(result == null)
			result_string =  "There is no solution";
		else {
			result_string += result.pathToString().toLowerCase() + result.getPathCost() + ";" + serching.getExpanded();
		}
		return result_string;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = solve("5,5;1,2;3,1;0,2,1,1,2,1,2,2,4,0,4,1;0,3,3,0,3,2,3,4,4,3", "AS2", true);
		System.out.println(result);
	}
	
	public static void drawGrid(List<Node> list) {
		int count =0;
		while(!list.isEmpty()) {
			String [][] Grid = new String[e.getRows()][e.getColumns()];
			EndGameState state = (EndGameState) list.get(0).getState();
			for (Byte stone : state.getStones()) {
				byte[] s =  e.decode_position(stone, e.getColumns());
				Grid[s[0]][s[1]] = "S";
			}
			
			for (Byte warrior : state.getWarriors()) {
				byte[] s =  e.decode_position(warrior, e.getColumns());
				Grid[s[0]][s[1]] = "W";
			}
			
			byte[] s_i =  e.decode_position(state.getIr(), e.getColumns());
			
			
			Grid[s_i[0]][s_i[1]] = "I";
			
			byte[] s_t =  e.decode_position(e.getThanos(), e.getColumns());
			Grid[s_t[0]][s_t[1]] = "T";
			
			for (int i = 0; i < Grid.length; i++) {
				for (int j = 0; j < Grid[i].length; j++) {
					if(Grid[i][j]==null) {
						System.out.print("| ");
					}else {
						System.out.print("|"+Grid[i][j]+"");
					}
				}
				System.out.println("\n");
			}
			
			System.out.println(count + " "+ list.get(0).getOperator()+" "+s_i[0] + " " + s_i[1]+" Damage="+list.get(0).getPathCost());
			
			System.out.println(state.getIr());
			
			for (byte w : state.getWarriors()) {
				System.out.print(w + "   ");
				
			}
			
			System.out.println();
			count++;
			System.out.println("===============");
			list.remove(0);
		}
	}
	
	public static void toString(String grid) {
		
	}

}
