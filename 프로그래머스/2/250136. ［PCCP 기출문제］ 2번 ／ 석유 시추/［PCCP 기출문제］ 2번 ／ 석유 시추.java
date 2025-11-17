import java.util.*;

class Solution {
    boolean[][] visited;
    int[] oil;
    int n, m;
        
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        oil = new int[m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(land[i][j]==1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }
        
        Arrays.sort(oil);
        answer = oil[m-1];
        return answer;
    }
    public void bfs(int x, int y, int[][] land) {
        visited[x][y] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        Set<Integer> set = new HashSet<>();
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int count = 1;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            set.add(cur[1]);
            
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny]) {
                    if(land[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        count += 1;
                    }
                }
            }
        }
        for(int index : set) {
            oil[index] += count;
        }
    }
}