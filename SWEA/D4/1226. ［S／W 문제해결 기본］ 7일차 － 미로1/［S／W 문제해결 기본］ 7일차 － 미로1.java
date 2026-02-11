import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static int N = 16;
	static int[][] map = new int[16][16];
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int startr;
	static int startc;
	static boolean success;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<10; t++) {
			int T = Integer.parseInt(br.readLine());
			for(int i=0; i<16; i++) {
				String s = br.readLine();
				for(int j=0; j<16; j++) {
					map[i][j] = s.charAt(j) - '0';
					if(map[i][j] == 2) {
						startr = i;
						startc = j;
					}
				}
 			}
			
			success = false;
			visited = new boolean[16][16];
			
			bfs(startr, startc);
			
			if(success) {
				System.out.println("#"+T+" "+1);
			} else {
				System.out.println("#"+T+" "+0);
			}
		}
	}
	
	static void bfs(int r, int c) {
		visited[r][c] = true;
		
		if(map[r][c] == 3) {
			success = true;
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<16 && nc>=0 && nc<16) {
				if(map[nr][nc] != 1 && !visited[nr][nc]) {
					bfs(nr, nc);
				}
			}
		}
	}
}
