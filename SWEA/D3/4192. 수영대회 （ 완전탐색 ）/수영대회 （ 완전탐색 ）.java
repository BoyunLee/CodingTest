import java.util.*;
import java.io.*;

class Solution
{
    static int T;
	static int N;
	static int[][] map;
	static int sr, sc, er, ec;
	static boolean[][] visited;
	static int result;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Queue<int[]> points;
	

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			StringTokenizer st = null;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc =  Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			result = -1;
			
			points = new ArrayDeque<>();
			
			points.add(new int[] {sr, sc, 0});
			visited[sr][sc] = true;
			
			while(!points.isEmpty()) {
				int[] temp = points.poll();
				int r = temp[0], c = temp[1], time = temp[2];
				
				if(r==er && c==ec) {
					result = time;
					break;
				}
				
				for(int i=0; i<4; i++) {
					int nr = r+dr[i];
					int nc = c+dc[i];
					
					if(0<=nr && 0<=nc && nr<N && nc<N) {
						if(!visited[nr][nc] && map[nr][nc]==0) {
							visited[nr][nc] = true;
							points.add(new int[] {nr, nc, time+1});
						}
					}
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}