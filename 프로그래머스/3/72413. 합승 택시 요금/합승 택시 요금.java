import java.util.*;

class Edge implements Comparable<Edge> {
    int node, cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.cost, other.cost);
    }
}

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 그래프 초기화
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int w = fare[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new Edge(v, w));
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(new Edge(u, w));
        }

        // 다익스트라 알고리즘을 사용하여 최단 거리 계산
        int[] distFromS = dijkstra(graph, s, n);
        int[] distFromA = dijkstra(graph, a, n);
        int[] distFromB = dijkstra(graph, b, n);

        // 최소 비용 계산
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (distFromS[i] != Integer.MAX_VALUE && distFromA[i] != Integer.MAX_VALUE && distFromB[i] != Integer.MAX_VALUE) {
                int cost = distFromS[i] + distFromA[i] + distFromB[i];
                minCost = Math.min(minCost, cost);
            }
        }
        
        return minCost;
    }

    private int[] dijkstra(Map<Integer, List<Edge>> graph, int start, int n) {
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (distance[cur.node] < cur.cost) {
                continue;
            }

            List<Edge> edges = graph.get(cur.node);
            if (edges != null) {
                for (Edge next : edges) {
                    int nextCost = distance[cur.node] + next.cost;
                    if (nextCost < distance[next.node]) {
                        distance[next.node] = nextCost;
                        pq.add(new Edge(next.node, nextCost));
                    }
                }
            }
        }

        return distance;
    }
}
