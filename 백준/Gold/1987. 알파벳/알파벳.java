import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static int[][] map;
	static boolean[] alpa;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		alpa = new boolean[26];
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = line.charAt(j) - 'A';
			}
		}
		
		count = 0;
		bfs(0, 0, 1);
		System.out.println(count);
	}
	
	static void bfs(int r, int c, int depth) {
		
		count = Math.max(count, depth);		
		alpa[map[r][c]] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0 && nr<R && nc>=0 && nc<C) {
				if(!alpa[map[nr][nc]]) {
					bfs(nr, nc, depth+1);
				}
			}
		}
		alpa[map[r][c]] = false;
	}
}
