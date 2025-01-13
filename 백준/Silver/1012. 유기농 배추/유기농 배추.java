import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1}; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int text = sc.nextInt();

        for (int t=0; t<text; t++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();

            map = new int[M][N];
            visited = new boolean[M][N];

            for (int i=0; i<K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }

            int count = 0;

            for (int i=0; i<M; i++) {
                for (int j=0; j<N; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j, M, N);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y, int M, int N) {
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny, M, N);
                }
            }
        }
    }
}