import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] graph = new ArrayList[101];
			for(int i=1; i<=100; i++) {
				graph[i] = new ArrayList<>(); 
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
			}
			
			boolean[] visited = new boolean[101];
			Deque<int[]> queue = new ArrayDeque<>();
			visited[start] = true;
			queue.offer(new int[] {start, 0});
	
			int answer = 0;
			int depth = 0;
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				
				for(int num : graph[cur[0]]) {
					if(!visited[num]) {
						visited[num] = true;
						queue.add(new int[] {num, cur[1]+1});
						if(depth < cur[1]+1) {
							depth = cur[1]+1;
							answer = num;
						} else if(depth == cur[1]+1) {
							if(num > answer) {
								answer = num;
							}
						}
					}
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}
