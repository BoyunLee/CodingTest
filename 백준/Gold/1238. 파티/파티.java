import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, X;
	static int max_value = 1_000_000;

	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		List<Edge>[] adj = new ArrayList[N + 1];
		List<Edge>[] reverseAdj = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
			reverseAdj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adj[from].add(new Edge(to, weight));
			reverseAdj[to].add(new Edge(from, weight));
		}

		int[] dist1 = dijkstra(adj);
		int[] dist2 = dijkstra(reverseAdj);

		int result = 0;

		for (int i = 1; i <= N; i++) {
			result = Math.max(result, dist1[i] + dist2[i]);
		}
		System.out.println(result);
	}

	static int[] dijkstra(List<Edge>[] adjList) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(X, 0));
		int[] dist = new int[N + 1];
		Arrays.fill(dist, max_value);
		dist[X] = 0; // 시작점은 거리 0

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			int to = curr.to;
			int weight = curr.weight;

			if (dist[to] < weight)
				continue;

			for (Edge next : adjList[to]) {
				if (dist[next.to] > dist[to] + next.weight) {
					dist[next.to] = dist[to] + next.weight;
					pq.offer(new Edge(next.to, dist[next.to]));
				}
			}
		}
		return dist;
	}
}