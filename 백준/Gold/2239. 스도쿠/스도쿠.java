import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static int[][] map;
	static List<int[]> empties;
	static int size;
	static boolean[][] rowUsed;
	static boolean[][] colUsed;
	static boolean[][] boxUsed;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		empties = new ArrayList<>();
		size = 0;
		rowUsed = new boolean[9][10];
		colUsed = new boolean[9][10];
		boxUsed = new boolean[9][10];
		
		for(int i=0; i<9; i++) {
			String Line = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j] = Line.charAt(j) - '0';
				if(map[i][j] == 0) {
					empties.add(new int[] {i, j});
				} else {
					rowUsed[i][map[i][j]] = true;
					colUsed[j][map[i][j]] = true;
					int box = (i/3)*3 + (j/3);
		            boxUsed[box][map[i][j]] = true;
				}
			}	
		}
		
		size = empties.size();
		solved(0);

		for(int i=0; i<9; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<9; j++) {
				sb.append(map[i][j]);
			}
			System.out.println(sb);
		}
	}
	
	static boolean solved(int idx) {
		if(idx == size) {
			return true;
		}
		
		int[] cur = empties.get(idx);
		int r = cur[0];
		int c = cur[1];
		int b = (r/3)*3 + (c/3);
		
		for(int i=1; i<=9; i++) {
			if(rowUsed[r][i] == false && colUsed[c][i] == false && boxUsed[b][i] == false) {
				map[r][c] = i;
				rowUsed[r][i] = true;
				colUsed[c][i] = true;
				boxUsed[b][i] = true;
				
				if(solved(idx+1)) {
					return true;
				}
				
				map[r][c] = 0;
				rowUsed[r][i] = false;
				colUsed[c][i] = false;
				boxUsed[b][i] = false;
			}	
		}
		return false;
	}
}
