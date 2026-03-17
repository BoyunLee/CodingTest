import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int M;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
			}
			
			visited = new boolean[M][N];
			int count = 0;
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString().trim());
	}
	static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<M && nc>=0 && nc<N) {
				if(map[nr][nc]==1 && !visited[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}
}