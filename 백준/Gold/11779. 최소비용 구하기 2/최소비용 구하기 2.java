import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int v;
		int cost;
		
		public Edge(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(u).add(new Node(v, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] cost = new int[n + 1];
        int[] prev = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		cost[start] = 0;
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(cur.cost != cost[cur.v]) continue;
			
			for(Node next : list.get(cur.v)) {
				if(cost[next.v] > cost[cur.v] + next.w) {
					cost[next.v] = cost[cur.v] + next.w;
					prev[next.v]= cur.v;
					pq.add(new Edge(next.v, cost[next.v]));
				}
			}
		}
		
		ArrayList<Integer> path = new ArrayList<>();
        int now = end;
        while (now != 0) {
            path.add(now);
            if (now == start) break;
            now = prev[now];
        }

        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        for (int city : path) {
            sb.append(city).append(" ");
        }

        System.out.println(cost[end]);
        System.out.println(path.size());
        System.out.println(sb);
	}
}