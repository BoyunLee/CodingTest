import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] dc = {0, -1, 0, 1, -1, 1, -1, 1};
	static int answer;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) {
				break;
			}
			
			map = new int[h][w];
			visited = new boolean[h][w];
			answer = 0;
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						answer++;
						dfs(i, j);
					}
				}
			}
			System.out.println(answer);
 		}
	}
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d=0; d<8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<h && nc>=0 && nc<w) {
				if(!visited[nr][nc] && map[nr][nc] == 1) {
					dfs(nr, nc);
				}
			}
		}
	}
}