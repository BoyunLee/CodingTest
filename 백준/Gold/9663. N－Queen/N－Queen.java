import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static boolean[] col;
	static boolean[] cross1;
	static boolean[] cross2;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new boolean[N];
		cross1 = new boolean[2*N];
		cross2 = new boolean[2*N];
		
		count = 0;
		dfs(0);
		
		System.out.println(count);
	}
	
	static void dfs(int row) {
		if(row == N) {
			count++;
			return;
		}
		
		for(int c=0; c<N; c++) {
			if(col[c] || cross1[row+c] || cross2[row-c+N-1]) {
				continue;
			}
			
			col[c] = true;
			cross1[row+c] = true;
			cross2[row-c+N-1] = true;
			dfs(row+1);
			cross2[row-c+N-1] = false;
			cross1[row+c] = false;
			col[c] = false;
		}
	}

}