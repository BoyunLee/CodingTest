import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) + 100;
			int y1 = Integer.parseInt(st.nextToken()) + 100;
			int x2 = Integer.parseInt(st.nextToken()) + 100;
			int y2 = Integer.parseInt(st.nextToken()) + 100;
			
			int answer = bfs(x1, y1, x2, y2);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static int bfs(int x1, int y1, int x2, int y2) {
		boolean[][][] visited = new boolean[201][201][2];
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.add(new int[] {x1, y1, 0, 0}); // 가로
		queue.add(new int[] {x1, y1, 1, 0}); // 세로
		
		visited[x1][y1][0] = true;
		visited[x1][y1][1] = true;
		
		while(!queue.isEmpty()) {
			 int[] temp = queue.poll();
			 
			 int r = temp[0];
			 int c = temp[1];
			 int dir = temp[2];
			 int cnt = temp[3];
			 
			 if(r==x2 && c==y2) {
				 return cnt;
			 }
			 
			 if(dir == 0) {
				 int dr[] = {0, 0};
				 int dc[] = {1, -1};
				 
				 for(int d=0; d<2; d++) {
					 int nr = r+dr[d];
					 int nc = c+dc[d];
					 
					 if(nr>=0 && nr<201 && nc>=0 && nc<201) {
						 if(!visited[nr][nc][1]) {
							 visited[nr][nc][1] = true;
							 queue.add(new int[] {nr, nc, 1, cnt+1});
						 }
					 }
				 }
			 } else if(dir == 1) {
				 int dr[] = {1, -1};
				 int dc[] = {0, 0};
				 
				 for(int d=0; d<2; d++) {
					 int nr = r+dr[d];
					 int nc = c+dc[d];
					 
					 if(nr>=0 && nr<201 && nc>=0 && nc<201) {
						 if(!visited[nr][nc][0]) {
							 visited[nr][nc][0] = true;
							 queue.add(new int[] {nr, nc, 0, cnt+1});
						 }
					 }
				 }
			 }
		}
		return -1;
	}
}