import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int[][] dp;
    static boolean[] visited;
    
    public int solution(int n, int[][] lighthouse) {
        
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<lighthouse.length; i++) {
            int u = lighthouse[i][0];
            int v = lighthouse[i][1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        dfs(1);
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    static void dfs(int idx) {
        visited[idx] = true;
        
        dp[idx][0] = 0;
        dp[idx][1] = 1;
        
        for(int next : graph[idx]) {
            if(visited[next]) continue;
            
            dfs(next);
            
            dp[idx][0] += dp[next][1];

            dp[idx][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}