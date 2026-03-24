import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		double cost;
		
		public Edge(int u, int v, double cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.cost, e.cost);
		}
	}
	
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				long dx = arr[i][0]-arr[j][0];
				long dy = arr[i][1]-arr[j][1];
				double dist = Math.sqrt((dx * dx) + (dy * dy));
				edges.add(new Edge(i, j, dist));
			}
		}
		
		double answer = 0;
		
		while(!edges.isEmpty()) {
			Edge e = edges.poll();
			if(find(e.u) != find(e.v)) {
				union(e.u, e.v);
				answer += e.cost;
			}
		}
		
		System.out.printf("%.2f\n", answer);
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) parent[b] = a;
	}
}
