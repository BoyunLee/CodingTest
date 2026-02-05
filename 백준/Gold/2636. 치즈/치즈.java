import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] melt;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int cheeze;
	static int cnt;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M]; 
		melt = new boolean[N][M]; 
		cheeze = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cheeze++;
				}
			}
		}
		
		fill(0, 0);
		
		cnt = 0;
		
		while(cheeze>0) {
			answer = cheeze;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1) {
						ismelt(i, j);
					}
				}
			}
			delect();
			cnt++;
			
			visited = new boolean[N][M];
			fill(0, 0);
		}
		
		System.out.println(cnt);
		System.out.println(answer);
	}
	
	static void fill(int r, int c) {
		map[r][c] = 2;
		visited[r][c] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				if(map[nr][nc] != 1 && !visited[nr][nc]) {
					fill(nr, nc);
				}
			}
		}
	}
	
	static void ismelt(int r, int c) {
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				if(map[nr][nc] == 2) {
					melt[r][c] = true;
					break;
				}
			}
		}
	}
	
	static void delect() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(melt[i][j]) {
					melt[i][j] = false;
					map[i][j] = 0;
					cheeze--;
				}
			}
		}
	}
}