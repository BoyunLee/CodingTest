import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int count;
	static int[] col;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N];
		
		dfs(0);
		
		System.out.println(count);
	}
	
	static void dfs(int row) {
		if(row == N) {
			count++;
			return;
		}
		
		for(int c=0; c<N; c++) {
			col[row] = c;
			
			if(isPossible(row)) {
				dfs(row+1);
			}
		}
	}
	
	static boolean isPossible(int row) {
		for(int r=0; r<row; r++) {
			if(col[r] == col[row]) {
				return false;
			}
			
			if(Math.abs(row-r) == Math.abs(col[row] - col[r])) {
				return false;
			}
		}
		return true;
	}
}
