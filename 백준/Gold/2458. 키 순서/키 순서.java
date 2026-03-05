import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> graph = new ArrayList<>(); 
		List<List<Integer>> graph2 = new ArrayList<>(); 
		for (int i = 0; i <= N; i++) {
		    graph.add(new ArrayList<>());
		    graph2.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph2.get(v).add(u);
		}
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			int taller = count(i, graph);
			int smaller = count(i, graph2);
			
			if(taller+smaller == N-1) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	
	static int count(int s, List<List<Integer>> g) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		queue.add(s);
		visited[s] = true;
		
		int count = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int next : g.get(cur)) {
				if(!visited[next]) {
					visited[next] = true;
					queue.add(next);
					count++;
				}
			}
		}
		return count;
	}
}
