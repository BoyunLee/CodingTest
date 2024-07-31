import java.util.*;

class Solution {
    
    // BFS 함수 정의
    private int bfs(String[] maps, int[] start, int[] end) {
        int rows = maps.length;
        int cols = maps[0].length();
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우 하 좌 상
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        
        queue.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                if (current[0] == end[0] && current[1] == end[1]) {
                    return steps;
                }
                for (int[] dir : directions) {
                    int newRow = current[0] + dir[0];
                    int newCol = current[1] + dir[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        !visited[newRow][newCol] && maps[newRow].charAt(newCol) != 'X') {
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            steps++;
        }
        return -1; // 경로가 없을 경우
    }
    
    public int solution(String[] maps) {
        int answer = -1;
        
        int row = maps.length;
        int col = maps[0].length();
        
        // 각 문자의 위치를 저장할 변수
        int lrow = -1, lcol = -1;
        int srow = -1, scol = -1;
        int erow = -1, ecol = -1;

        // 미로를 순회하여 각 문자의 위치 찾기
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maps[i].charAt(j) == 'L') {
                    lrow = i;
                    lcol = j;
                } else if (maps[i].charAt(j) == 'S') {
                    srow = i;
                    scol = j;
                } else if (maps[i].charAt(j) == 'E') {
                    erow = i;
                    ecol = j;
                }
            }
        }
        
        // BFS 수행
        int toL = bfs(maps, new int[]{srow, scol}, new int[]{lrow, lcol});
        int toE = bfs(maps, new int[]{lrow, lcol}, new int[]{erow, ecol});
        
        if (toL == -1 || toE == -1) {
            return -1; // S -> L 또는 L -> E 경로가 없으면 -1 반환
        }
        return toL + toE;
    }
}
