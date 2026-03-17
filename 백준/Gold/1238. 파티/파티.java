import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge {
		int end;
		int time;
		
		public Edge(int end, int time) {
			this.end = end;
			this.time = time;
		}
	}
	
	static class Node implements Comparable<Node> {
		int v;
		int total;
		
		public Node(int v, int total) {
			this.v = v;
			this.total = total;
		}

		@Override
		public int compareTo(Node o) {
			return this.total - o.total;
		}
	}
	
	static List<Edge>[] graph;
	static int N;
	static int X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b, c));
		}
		
		int[] sum = new int[N+1];
		for(int i=1; i<=N; i++) {
			int[] distFromI = dijkstra(i);
			sum[i] = distFromI[X];
		}
		
		int[] distFromX = dijkstra(X);
		for (int i = 1; i <= N; i++) {
		    sum[i] += distFromX[i];
		}
		
		sum[X] = 0;
		int max = 0;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, sum[i]);
		}
		
		System.out.println(max);
	}
	
	static int[] dijkstra(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE/100);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.total > dist[cur.v]) continue;
			
			for(Edge e : graph[cur.v]) {
				int next = e.end;
				int newDist = dist[cur.v] + e.time;
				
				if(newDist < dist[next]) {
					dist[next] = newDist;
					pq.add(new Node(next, newDist));
				}
			}
		}
		return dist;
	}
}