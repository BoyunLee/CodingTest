import java.util.*;

class Solution {
    
    static class Edge implements Comparable<Edge> {
        int v;
        int cost;
        
        Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        List<Edge>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        
        boolean[] visited = new boolean[n];
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));
        
        int count = 0;
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            
            if(visited[cur.v]) continue;
            
            visited[cur.v] = true;
            answer += cur.cost;
            count++;
            
            if(count == n) break;
            
            for(Edge next : graph[cur.v]) {
                if(!visited[next.v]) {
                    pq.offer(new Edge(next.v, next.cost));
                }
            } 
        }
        return answer;
    }
}