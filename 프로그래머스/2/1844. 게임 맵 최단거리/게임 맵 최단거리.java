import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], dist = cur[2];
            
            if(r==n-1 && c==m-1) {
                return dist;
            }
            
            for(int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m ) {
                    if(!visited[nr][nc] && maps[nr][nc]==1) {
                        visited[nr][nc] = true;
                        queue.add(new int[] {nr, nc, dist+1});
                    }
                }
            }
        }
        return answer;
    }
}