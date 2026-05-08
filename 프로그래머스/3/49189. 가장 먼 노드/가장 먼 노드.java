import java.util.*;

class Solution {
    static int[] depths;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        depths = new int[n+1];
        visited = new boolean[n+1];
        dfs(1);
        depths[1] = 1;
        
        int maxDepth = 0;
        for(int i=0; i<=n; i++) {
            maxDepth = Math.max(maxDepth, depths[i]);
        }
        
        for(int i=0; i<=n; i++) {
            if(maxDepth == depths[i]) answer++;
        }

        return answer;
    }
    
    static void dfs(int start) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : graph[cur]) {

                if(visited[next]) continue;

                visited[next] = true;
                depths[next] = depths[cur] + 1;

                queue.offer(next);
            }
        }
    }
}