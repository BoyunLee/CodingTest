import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        // 각 대기실 별로 거리두기 준수 여부를 확인
        for (int i = 0; i < answer.length; i++) {
            if (check(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
    
    boolean check(String[] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
	            // 응시자(P) 위치 마다 BFS를 수행
                if (place[r].charAt(c) == 'P') {
                    if (!bfs(r, c, place)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    boolean bfs(int r, int c, String[] place) {
        final int[] dr = {  0,  1,  0, -1 };
        final int[] dc = {  1,  0, -1,  0 };
        
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{ r, c, 0 });
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            if (cur[2] >= 2) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                int ndist = cur[2]+1;
                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
                    if (!visited[nr][nc] && place[nr].charAt(nc) != 'X') {
                        if (!visited[nr][nc]) {
                            // 거리두기를 준수하지 않았기 때문에 False를 반환한다.
                            if (place[nr].charAt(nc) == 'P') return false;
                            queue.add(new int[]{ nr, nc, ndist });
                            visited[nr][nc] = true;    
                        }
                    }
                }
            }
        }
        return true;
    }
}