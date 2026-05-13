import java.util.*;

class Solution {

    static int n;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        n = game_board.length;
        visited = new boolean[n][n];
        List<List<int[]>> blanks = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(game_board[i][j]==0 && !visited[i][j]) {
                    List<int[]> blank = getShape(i, j, game_board, 0);
                    blanks.add(blank);
                }
            }
        }
        
        visited = new boolean[n][n];
        List<List<int[]>> puzzles = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(table[i][j]==1 && !visited[i][j]) {
                    List<int[]> puzzle = getShape(i, j, table, 1);
                    puzzles.add(puzzle);
                }
            }
        }
        
        boolean[] used = new boolean[puzzles.size()];
        for(List<int[]> blank : blanks) {
            for(int p=0; p<puzzles.size(); p++) {
                if(used[p]) continue;
                
                List<int[]> puzzle = puzzles.get(p);
                if(blank.size() != puzzle.size()) continue;
                
                boolean matched = false;
                for(int rot=0; rot<4; rot++) {
                    if(isSame(blank, puzzle)) {
                        used[p] = true;
                        matched = true;
                        answer += puzzle.size();
                        break;
                    }
                    puzzle = rotate(puzzle);
                }
                if(matched) break;
            }
        }
        return answer;
    }
    
    static List<int[]> getShape(int r, int c, int[][] map, int num) {
        List<int[]> shape = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        visited[r][c] = true;
        shape.add(new int[] {0, 0});
        queue.add(new int[] {r, c});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int d=0; d<4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(nr>=0 && nr<n && nc>=0 && nc<n) {
                    if(map[nr][nc]==num && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        shape.add(new int[] {nr-r, nc-c});
                        queue.add(new int[] {nr, nc});
                    }
                }
            }
        }
        normalize(shape);
        return shape;
    }
    
    static void normalize(List<int[]> shape) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        
        for(int[] s : shape) {
            minR = Math.min(s[0], minR);
            minC = Math.min(s[1], minC);
        }
        
        for(int[] s : shape) {
            s[0] -= minR;
            s[1] -= minC;
        }
        sortShape(shape);
    }
    
    static void sortShape(List<int[]> shape) {
        Collections.sort(shape, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
    }
    
    static boolean isSame(List<int[]> blank, List<int[]> puzzle) {
        for(int i=0; i<blank.size(); i++) {
            if(blank.get(i)[0] != puzzle.get(i)[0]) return false;
            if(blank.get(i)[1] != puzzle.get(i)[1]) return false;
        }
        return true;
    }
    
    static List<int[]> rotate(List<int[]> puzzle) {
        List<int[]> rotated = new ArrayList<>();
        
        for(int[] p : puzzle) {
            int r = p[0];
            int c = p[1];
            rotated.add(new int[]{c, -r});
        }
        
        normalize(rotated);

        return rotated;
    }
}