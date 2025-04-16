import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N+1][M+1];
        map = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String line = sc.next();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }
        
        int answer = bfs(N, M);

        System.out.println(answer);
    }

    static int bfs(int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1, 1});
        visited[1][1] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int path = current[2];

            if(x == N && y == M) {
                return path;
            }

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                    if(!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, path+1});
                    }
                }
            }
        }
        return -1;
    }
}
