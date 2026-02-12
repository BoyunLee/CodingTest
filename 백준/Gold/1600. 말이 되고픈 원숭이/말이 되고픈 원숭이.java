import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int K;
	static int W;
	static int H;
	static int[][] map;
	static int[] hr = {1, 1, -1, -1, 2, 2, -2, -2};
	static int[] hc = {2, -2, 2, -2, 1, -1, 1, -1};
	static int[] mr = {0, 1, 0, -1};
	static int[] mc = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = bfs(0, 0);	

		System.out.println(answer);
	}

	static int bfs(int x, int y) {
		boolean[][][] visited = new boolean[H][W][K+1];
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.add(new int[] {x, y, 0, 0});
		visited[x][y][0] = true;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			int r = temp[0];
			int c = temp[1];
			int k = temp[2];
			int dist = temp[3];
			
			if(r==H-1 && c==W-1) {
				return dist;
			}
			
			for(int d=0; d<4; d++) {
				int nr = r+mr[d];
				int nc = c+mc[d];
				
				if(nr>=0 && nr<H && nc>=0 && nc<W) {
					if(map[nr][nc] == 0 && !visited[nr][nc][k]) {
						visited[nr][nc][k] = true;
						queue.add(new int[] {nr, nc, k, dist+1});
					}
				}
			}
			
			if(k<K) {
				for(int d=0; d<8; d++) {
					int nr = r+hr[d];
					int nc = c+hc[d];
					
					if(nr>=0 && nr<H && nc>=0 && nc<W) {
						if(map[nr][nc] == 0 && !visited[nr][nc][k+1]) {
							visited[nr][nc][k+1] = true;
							queue.add(new int[] {nr, nc, k+1, dist+1});
						}
					}
				}
			}
		}
		return -1;
	}
}
