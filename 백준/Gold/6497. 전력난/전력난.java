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
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(m == 0) break;
			
			Edge[] edges = new Edge[n];
			int sum = 0;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				
				edges[i] = new Edge(x, y, z);
				sum += z;
			}
			
			Arrays.sort(edges);
			
			parent = new int[m];
			for(int i=0; i<m; i++) {
				parent[i] = i;
			}
			
			long answer = 0;
			int count = 0;
			
			for(Edge e : edges) {
				if(find(e.u) != find(e.v)) {
					union(e.u, e.v);
					answer += e.w;
					count++;
					if(count == n-1) break;
				}
			}
			System.out.println(sum-answer);
		}
	}
	
	static void union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u != v) parent[v] = u;
	}
	
	static int find(int u) {
		if(parent[u] == u) return u;
		return parent[u] = find(parent[u]);
	}
}