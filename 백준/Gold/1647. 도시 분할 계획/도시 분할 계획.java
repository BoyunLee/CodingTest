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
	
	static int N;
	static int M;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
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
		
		int answer = 0;
		int max = 0;
		int count = 0;
		
		for(Edge e : edges) {
			if(find(e.u) != find(e.v)) {
				union(e.u, e.v);
				answer += e.w;
				max = Math.max(max, e.w);
				count++;
				if(count == N-1) {
					break;
				}
			}
		}
		answer -= max;
		System.out.println(answer);
	}
	
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	static void union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u != v) parent[v] = u;
	}
}
