import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge {
		int v;
		int w;
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static class Node implements Comparable<Node> {
		int v;
		int cost;
		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<List<Edge>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Edge(v, w));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		if(S == E) {
			System.out.println(0);
			return;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int INF = Integer.MAX_VALUE;
		boolean[] visited = new boolean[N+1];
		int[] dp = new int[N+1]; 
		Arrays.fill(dp, INF);
		pq.add(new Node(S, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.v]) {
				continue;
			}
			
			visited[cur.v] = true;
			
			for(Edge e : graph.get(cur.v)) {
				if(dp[e.v] > e.w + cur.cost) {
					dp[e.v] = e.w + cur.cost;
					pq.add(new Node(e.v, dp[e.v]));
				}
			}
		}
		System.out.println(dp[E]);
	}
}
