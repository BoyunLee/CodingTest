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
	
	static int V;
	static int E;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(A, B, C);
		}
		
		Arrays.sort(edges);
		
		parent = new int[V+1];
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		
		int answer = 0;
		int count = 0;
		
		for(Edge e : edges) {
			if(find(e.u) != find(e.v)) {
				union(e.u, e.v);
				answer += e.w;
				count++;
				if(count == V-1) break;
			}
		}
		System.out.println(answer);
	}
	
	static int find(int u) {
		if(parent[u] == u) return u;
		return parent[u] = find(parent[u]);
	}

	static void union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u != v) parent[v] = u;	
	}
}
