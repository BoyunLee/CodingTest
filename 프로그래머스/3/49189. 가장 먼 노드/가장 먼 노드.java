import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return bfs(graph, n, 1);
    }
    private int bfs(Map<Integer, List<Integer>> graph, int n, int start) {
        int maxdist = 0;
        int count = 0;
        
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> distqueue = new ArrayDeque<>();
        
        queue.offer(start);
        distqueue.offer(0);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int dist = distqueue.poll();
            
            if(maxdist < dist) {
                maxdist = dist;
                count = 1;
            } else if (dist == maxdist) {
                count++;
            }
            
            for (int next : graph.get(cur)) {
                if(!visited[next]) {
                    queue.offer(next);
                    distqueue.offer(dist+1);
                    visited[next] = true;
                }
            }
        }
        return count;
    }
}