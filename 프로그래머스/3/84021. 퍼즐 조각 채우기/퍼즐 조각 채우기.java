import java.util.*;

class Solution {
    
    static int[][] game_board;
    static int[][] table;
    static int n;
    static int m;
    static List<List<int[]>> puzzles;
    static List<List<int[]>> blanks;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};  
    static boolean[][] visited;
    static int answer;
    
    public int solution(int[][] game_board, int[][] table) {
        answer = 0;
        
        Solution.table = table;
        Solution.game_board = game_board;
        
        n = game_board.length;
        m = game_board[0].length;
        
        puzzles = new ArrayList<>(); 
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(table[i][j] == 1 && !visited[i][j]) {
                    List<int[]> shape = bfsPuzzle(i, j);
                    puzzles.add(shape);
                }
            }
        }
        
        blanks = new ArrayList<>();
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(game_board[i][j] == 0 && !visited[i][j]) {
                    List<int[]> shape = bfsBlank(i, j);
                    blanks.add(shape);
                }
            }
        }
        
        boolean[] used = new boolean[puzzles.size()];
        for(List<int[]> blank : blanks) {
            for(int i=0; i<puzzles.size(); i++) {
                if(used[i]) continue;
                
                List<int[]> puzzle = puzzles.get(i);
                if(blank.size() != puzzle.size()) continue;
                
                boolean matched = false;
                for(int rot=0; rot<4; rot++) {
                    if(isSame(blank, puzzle)) {
                        used[i] = true;
                        answer += blank.size();
                        matched = true;
                        break;
                    }
                    puzzle = rotate(puzzle);
                }
                if(matched) break;
            }
        }
        return answer;
    }
    
    static List<int[]> bfsPuzzle(int r, int c) {
        List<int[]> shape = new ArrayList<>();
        shape.add(new int[] {0, 0});
        
        Queue<int[]> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.add(new int[] {r, c});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int d=0; d<4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m) {
                    if(table[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[] {nr, nc});
                        shape.add(new int[]{nr-r, nc-c});
                    }
                }
            }
        }
        normalize(shape);
        return shape;
    }
    
    static List<int[]> bfsBlank(int r, int c) {
        List<int[]> shape = new ArrayList<>();
        shape.add(new int[] {0, 0});
        
        Queue<int[]> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.add(new int[] {r, c});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int d=0; d<4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m) {
                    if(game_board[nr][nc] == 0 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[] {nr, nc});
                        shape.add(new int[]{nr-r, nc-c});
                    }
                }
            }
        }
        normalize(shape);
        return shape;
    }
    
    static boolean isSame(List<int[]> a, List<int[]> b) {
        for(int i=0; i<a.size(); i++) {
            if(a.get(i)[0] != b.get(i)[0]) return false;
            if(a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }
    
    static void sortShape(List<int[]> shape) {
        Collections.sort(shape, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
    }
    
    static List<int[]> rotate(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();

        for(int[] p : shape) {
            int r = p[0];
            int c = p[1];
            rotated.add(new int[]{c, -r});
        }

        normalize(rotated);

        return rotated;
    }
    
    static void normalize(List<int[]> shape) {

        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;

        for(int[] p : shape) {

            minR = Math.min(minR, p[0]);
            minC = Math.min(minC, p[1]);
        }

        for(int[] p : shape) {

            p[0] -= minR;
            p[1] -= minC;
        }

        sortShape(shape);
    }
}