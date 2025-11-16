import java.util.*;

class Solution {    
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};   
        
        while(!queue.isEmpty()) {
            int[] cur = queue.remove();
            int x = cur[0], y = cur[1], dist = cur[2];
            
            if(x == n-1 && y == m-1) {
                return dist;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny] == 1) {
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny, dist+1});
                    }
                }
            }
        }
        
        return answer;
    }
}