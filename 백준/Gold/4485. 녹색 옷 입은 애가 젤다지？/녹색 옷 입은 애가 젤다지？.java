import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[][] dp;
	static int N;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int index = 1;
		
		while(true) {
			N = Integer.parseInt(br.readLine());

			if(N == 0) {
				break;
			}
			
			map = new int[N][N];
			dp = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			
			bfs();
			
			int answer = dp[N-1][N-1];

			System.out.println("Problem "+(index++)+": "+answer);
		}
	}
	
	static void bfs() {
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		dp[0][0] = map[0][0];
		queue.add(new int[] {0, 0, dp[0][0]});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r=cur[0], c=cur[1], rupee=cur[2];
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(!isValid(nr, nc)) continue;
				
				if(rupee + map[nr][nc] < dp[nr][nc]) {
					dp[nr][nc] = rupee + map[nr][nc];
					queue.add(new int[] {nr, nc, dp[nr][nc]});
				}
			}
		}
	}
	
	static boolean isValid(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}