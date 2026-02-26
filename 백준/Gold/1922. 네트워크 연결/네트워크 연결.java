import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	static int[] parent;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		Edge[] edges = new Edge[M];
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(u, v, w);
		}
		
		Arrays.sort(edges);
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		int cost = 0;
		int count = 0;
		
		for(Edge e : edges) {
			if(check(e.u) != check(e.v)) {
				union(e.u, e.v);
				cost += e.w;
				count++;
				if(count == N-1) break;
			}
		}
		System.out.println(cost);
	}

	static int check(int x) {
		if(parent[x] == x) return x;
		return parent[x] = check(parent[x]);
	}
	
	static void union(int u, int v) {
		 u = check(u);
		 v = check(v);
		 if(u != v) parent[v] = u;
	}
}
