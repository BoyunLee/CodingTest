import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int cheese;
	static boolean[][] visited;
	static boolean[][] melt;
	static int cnt;
	static int answer;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		melt = new boolean[N][M];
		
		cheese = 0;
		answer = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cheese++;
				}
			}
		}
		
		while(cheese > 0) {
			visited = new boolean[N][M];
			fill(0, 0);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1) {
						check(i, j);
					}
				}
			}
			
			remove();
			
			answer++;
		}
		
		System.out.println(answer);
	}
	
	static void fill(int r, int c) {
		map[r][c] = 2;
		visited[r][c] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				if(map[nr][nc] != 1 && !visited[nr][nc]) {
					fill(nr, nc);
				}
			}
		}
	}
	
	static void check(int r, int c) {
		cnt = 0;
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 && nr>=N && nc<0 && nc>=M) continue;
			
			if(map[nr][nc] == 2) {
				cnt++;
			}
		}
		if(cnt>=2) {
			melt[r][c] = true;
		}
	}
	
	static void remove() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(melt[i][j]) {
					map[i][j] = 0;
					melt[i][j] = false;
					cheese--;
				}
			}
		}
	}
}