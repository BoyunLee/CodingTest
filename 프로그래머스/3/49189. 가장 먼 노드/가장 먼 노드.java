import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        // 인접 리스트로 변환
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i=0; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // dfs(1) 호출
        return bfs(graph, n, 1);
    }
    
    int bfs(Map<Integer, List<Integer>> graph, int n, int startVertex) {
        int maxDist = 0;
        int count = 0;
        
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startVertex, 0});
        visited[startVertex] = true;
        
        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int[] cur = queue.poll();
            int curVertex = cur[0];
            int dist = cur[1];
            
            if (dist > maxDist) {
                maxDist = dist;
                count = 1; // 새로운 최대 거리 발견 시 count 초기화
            } else if (dist == maxDist) {
                count++; // 같은 최대 거리를 가진 정점 추가
            }
            
            // 다음 노드 예약
            for (int nextVertex : graph.get(curVertex)) {
                if(!visited[nextVertex]) {
                    queue.offer(new int[]{nextVertex, dist+1});
                    visited[nextVertex] = true;
                }
            }
        }
        return count;
    }
}