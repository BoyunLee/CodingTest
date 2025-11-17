import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        
        int[][] route = new int[102][102]; 
        boolean[][] visited = new boolean[102][102];
        
        for (int i = 0; i < rectangle.length; i++) {
            rectangle[i][0] *= 2;
            rectangle[i][1] *= 2;
            rectangle[i][2] *= 2;
            rectangle[i][3] *= 2;
        }
        
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        for (int[] r : rectangle) {
            for (int i = r[0]; i <= r[2]; i++) {
                for (int j = r[1]; j <= r[3]; j++) {
                    route[i][j] = 1;
                }
            }
        }
        
        for (int[] r : rectangle) {
            for (int i = r[0] + 1; i < r[2]; i++) {
                for (int j = r[1] + 1; j < r[3]; j++) {
                    route[i][j] = 0;
                }
            }
        }
        
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        
        queue.add(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], dist = cur[2];
            if(r==itemX && c==itemY) {
                answer = dist/2;
                break;
            }
            for(int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(0<nr && nr<=102 && 0<nc && nc<=102 && route[nr][nc] == 1) {
                    if(!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc, dist+1});
                    }
                }
            }
        }
        return answer;
    }
}