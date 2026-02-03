import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1}; 
    static int house;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int count = 0;
        List<Integer> answer = new ArrayList<>();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    house = 0;
                    dfs(i, j, N);
                    count++;
                    answer.add(house);
                }
            }
        }

        System.out.println(count);
        Collections.sort(answer);
        for(int h : answer) {
            System.out.println(h);
        }
    }

    public static void dfs(int x, int y, int N) {
        visited[x][y] = true;
        house++;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny, N);
                }
            }
        }
    }
}
