import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] copy;
	static boolean[][] virusVisited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		block(0);
		System.out.println(answer);
	}
	
	static void block(int wall) {
		if(wall == 3) {
			int[][] copy = copyMap();
		    virus(copy); 
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					block(wall+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	private static int[][] copyMap() {
		copy = new int[N][M];
		
		for (int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}

	static void virus(int[][] copy) {
		virusVisited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copy[i][j] == 2 && !virusVisited[i][j]) {
					bfs(i, j);
				}
			}
		}
		safe();
	}
	
	static void bfs(int r, int c) {
		virusVisited[r][c] = true;
		copy[r][c] = 2;
			
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(0<=nr && nr<N && 0<=nc && nc<M) {
				if(copy[nr][nc] == 0 && !virusVisited[nr][nc]) {
					bfs(nr, nc);
				}
			}
		}
	}
	
	static void safe() {
		int safeArea = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copy[i][j] == 0) {
					safeArea++;
				}
			}
		}
		answer = Math.max(answer, safeArea);
	}
}
