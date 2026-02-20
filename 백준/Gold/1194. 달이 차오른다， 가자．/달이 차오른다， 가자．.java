import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static char[][] map;
	static int sr;
	static int sc;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int n=0; n<N; n++) {
			String line = br.readLine();
			for(int m=0; m<M; m++) {
				map[n][m] = line.charAt(m);
				if(map[n][m] == '0') {
					sr = n;
					sc = m;
				}
			}
		}
		
		int answer = bfs(sr, sc);
		
		System.out.println(answer);
	}
	
	static int bfs(int x, int y) {
		boolean[][][] visited = new boolean[N][M][64];
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.add(new int[] {x, y, 0, 0});
		visited[x][y][0] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int r = cur[0];
			int c = cur[1];
			int key = cur[2];
			int dist = cur[3];
			
			if(map[r][c] == '1') {
				return dist;
			}
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					char ch = map[nr][nc];
					
					if(ch == '#') continue;
					
					int nextkey = key;
					
					// 열쇠
					if(ch>='a' && ch<='f') {
						nextkey = key | (1 << (ch-'a'));
					}
					
					// 문
					if(ch>='A' && ch<='F') {
						// 열쇠확인
						// 없으면 못감
						if((key & (1 << (ch-'A'))) == 0) continue;
					}
					
					if(!visited[nr][nc][nextkey]) {
						visited[nr][nc][nextkey] = true;
						queue.add(new int[] {nr, nc, nextkey, dist+1});
					}
				}
			}
		}
		return -1;
	}
}
