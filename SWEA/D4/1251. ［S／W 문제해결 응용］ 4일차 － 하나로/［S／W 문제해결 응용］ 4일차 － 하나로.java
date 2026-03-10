import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				map[i][0] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			boolean[] visited = new boolean[N];
			long[] minEdge = new long[N];
			
			for(int i=0; i<N; i++) {
				minEdge[i] = Long.MAX_VALUE;
			}
			
			minEdge[0] = 0;
			long total = 0;
			
			for(int i=0; i<N; i++) {
				int u = -1;
				long min = Long.MAX_VALUE;
				
				for(int j=0; j<N; j++) {
					if(!visited[j] && minEdge[j] < min) {
						min = minEdge[j];
						u = j;
					}
				}
				
				visited[u] = true;
				total += min;
				
				for(int v=0; v<N; v++) {
					if(!visited[v]) {
						long dx = map[u][0] - map[v][0];
						long dy = map[u][1] - map[v][1];
						long cost = dx*dx + dy*dy;
						
						if(cost < minEdge[v]) {
							minEdge[v] = cost;
						}
					}
				}
			}
		
			long answer = Math.round(total*E);
					
			System.out.println("#"+t+" "+answer);
		}
	}
}