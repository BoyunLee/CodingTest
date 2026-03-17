import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] miro;
	static int[][] wall;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		miro = new int[N][M];
		for(int i=0; i<N; i++) {
			String Line = br.readLine();
			for(int j=0; j<M; j++) {
				miro[i][j] = Line.charAt(j) - '0';
			}
		}
		
		wall = new int[N][M];
		for (int i = 0; i < N; i++) {
		    Arrays.fill(wall[i], 100000);
		}
		
		wall[0][0] = 0;
		dfs(0, 0, 0);
		
		System.out.println(wall[N-1][M-1]);
	}
	
	static void dfs(int r, int c, int temp) {
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr>=0 && nr<N && nc<M && nc>=0) {
				int next = temp + miro[nr][nc];
				
				if(next < wall[nr][nc]) {
					wall[nr][nc] = next;
					dfs(nr, nc, next);
				}
			}
		}
	}
}