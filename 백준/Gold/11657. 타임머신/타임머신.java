import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge{
		int start;
		int end;
		int time;
		
		public Edge(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}
	
	static int N;
	static int M;
	static Edge[] edges;
	static long[] dist;
	static long INF = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edges = new Edge[M];
		dist = new long[N+1];
		for(int i=0; i<=N; i++) {
			dist[i] = INF;
		}
		dist[1] = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(a, b, c);
		}
		
		boolean cycle = bellmanFord();
		
		StringBuilder sb = new StringBuilder();
		
		if(cycle) {
			sb.append(-1);
		} else {
			for(int i=2; i<=N; i++) {
				if(dist[i] == INF) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dist[i]).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
	
	static boolean bellmanFord() {		
		for(int i=1; i<N; i++) {
			boolean updated = false;
			
			for(int j=0; j<M; j++) {
				Edge e = edges[j];
				
				if(dist[e.start] != INF && dist[e.end] > dist[e.start]+e.time) {
					dist[e.end] = dist[e.start]+e.time;
					updated = true;
				}
			}
			if(!updated) break;
		}
		
		for(int j=0; j<M; j++) {
			Edge e = edges[j];
			
			if(dist[e.start] != INF && dist[e.end] > dist[e.start]+e.time) {
				return true;
			}
		}
		return false;
	}
}
