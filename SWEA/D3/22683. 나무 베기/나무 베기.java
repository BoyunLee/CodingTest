import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Solution {
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0}; // 오 아래 왼 위
	
	static class Node {
		int r;
		int c;
		int dir;
		int cut;
		int cnt;
		
		Node(int r, int c, int dir, int cut, int cnt) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cut = cut;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[N][N];
			int sr = -1, sc = -1;
            int er = -1, ec = -1;
			for(int i=0; i<N; i++) {
				String Line = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = Line.charAt(j);
					if(map[i][j] == 'X') {
						sr = i;
						sc = j;
					} else if(map[i][j] == 'Y') {
						er = i;
						ec = j;
					}
				}
			}
			
			boolean[][][][] visited = new boolean[N][N][4][K+1];
			ArrayDeque<Node> queue = new ArrayDeque<>();
			visited[sr][sc][3][0] = true;
			queue.offer(new Node (sr, sc, 3, 0, 0));
			
			int answer = -1;
			
			while(!queue.isEmpty()) {
				Node cur = queue.poll();
				
				if(cur.r==er && cur.c==ec) {
					answer = cur.cnt;
					break;
				}
				
				// 직진
				int nr = cur.r + dr[cur.dir];
				int nc = cur.c + dc[cur.dir];
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(map[nr][nc]=='T' && cur.cut<K) {
						if(!visited[nr][nc][cur.dir][cur.cut+1]) {
							visited[nr][nc][cur.dir][cur.cut+1] = true;
							queue.add(new Node (nr, nc, cur.dir, cur.cut+1, cur.cnt+1));
						}
					} else if(map[nr][nc]!='T') {
						if(!visited[nr][nc][cur.dir][cur.cut]) {
							visited[nr][nc][cur.dir][cur.cut] = true;
							queue.add(new Node (nr, nc, cur.dir, cur.cut, cur.cnt+1));
						}
					}
				}
				
				// 우회전
				int right = (cur.dir+1)%4;
				if(!visited[cur.r][cur.c][right][cur.cut]) {
					visited[cur.r][cur.c][right][cur.cut] = true;
					queue.add(new Node (cur.r, cur.c, right, cur.cut, cur.cnt+1));
				}
				
				// 좌회전
				int left = (cur.dir+3)%4;
				if(!visited[cur.r][cur.c][left][cur.cut]) {
					visited[cur.r][cur.c][left][cur.cut] = true;
					queue.add(new Node (cur.r, cur.c, left, cur.cut, cur.cnt+1));
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}
