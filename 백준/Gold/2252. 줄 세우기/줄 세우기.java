import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int[] indeg = new int[N+1];
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			
			indeg[v]++;
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			if(indeg[i] == 0) {
				queue.add(i);
				sb.append(i).append(' ');
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int next : graph[cur]) {
				indeg[next]--;
				if(indeg[next] == 0) {
					sb.append(next).append(' ');
					queue.add(next);
				}
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
