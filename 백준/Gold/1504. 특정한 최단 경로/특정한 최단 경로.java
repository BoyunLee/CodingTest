import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int v;
		int w;
		
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.w - e.w;
		}
	}
	
	static int N;
	static ArrayList<Edge>[] list;
	static int INF = 1000000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b, c));
			list[b].add(new Edge(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int[] dist1 = dijkstra(1);
		int[] distv1 = dijkstra(v1);
		int[] distv2 = dijkstra(v2);
		
		long sum1 = dist1[v1] + distv1[v2] + distv2[N];
		long sum2 = dist1[v2] + distv2[v1] + distv1[N];
		
		if(dist1[v1] >= INF || distv1[v2] >= INF || distv2[N] >= INF) {
			sum1 = INF;
		}
		
		if(dist1[v2] >= INF || distv2[v1] >= INF || distv1[N] >= INF) {
			sum2 = INF;
		}
		
		long answer = Math.min(sum1, sum2);
		
		if(answer >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
	
	static int[] dijkstra(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(cur.w > dist[cur.v]) {
				continue;
			}
			
			for(Edge next : list[cur.v]) {
				if(dist[next.v] > dist[cur.v] + next.w) {
					dist[next.v] = dist[cur.v] + next.w;
					pq.offer(new Edge(next.v, dist[next.v]));
				}
			}
		}
		return dist;
	}
}
