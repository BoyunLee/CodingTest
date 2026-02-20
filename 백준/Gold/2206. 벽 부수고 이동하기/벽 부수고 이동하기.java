import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		int answer = bfs(0, 0);
		
		System.out.println(answer);
	}
	
	static int bfs(int x, int y) {
		visited = new boolean[N][M][2];
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.add(new int[] {x, y, 0, 1});
		visited[x][y][0] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int r = cur[0];
			int c = cur[1];
			int w = cur[2];
			int dist = cur[3];
			
			if(r == N-1 && c == M-1) {
				return dist;
			}
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(map[nr][nc] == 0 && !visited[nr][nc][w]) {
						visited[nr][nc][w] = true;
						queue.add(new int[] {nr, nc, w, dist+1});
					}
					
					if(map[nr][nc] == 1 && w == 0 && !visited[nr][nc][1]) {
						visited[nr][nc][1] = true;
						queue.add(new int[] {nr, nc, 1, dist+1});
					}
				}
			}
		}
		return -1;
	}
}
