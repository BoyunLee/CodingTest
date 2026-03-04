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
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
	
	static class Node implements Comparable<Node>{
        int v;
        int dist;
        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dist, o.dist);
		}
    }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		List<List<Edge>> graph = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Edge(v, w));
		}
		
		int[] dp = new int[V+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[K] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(K, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.dist != dp[cur.v]) continue;
			
			for(Edge n : graph.get(cur.v)) {
				int nd = cur.dist + n.w;
				if(nd < dp[n.v]) {
					dp[n.v] = nd;
					pq.add(new Node(n.v, nd));
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			System.out.println( dp[i] == Integer.MAX_VALUE ? "INF" : dp[i]);
		}
	}
}			