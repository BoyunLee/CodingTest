import java.util.*;

public class Main {
    static int w;
    static int h;
    static int[][] arr;
    static boolean[][] visited;
    static int answer;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            arr = new int[h][w];
            visited = new boolean[h][w];
            answer = 0;

            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if(!visited[nx][ny] && arr[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
