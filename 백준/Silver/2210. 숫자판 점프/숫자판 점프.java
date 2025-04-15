import java.util.*;

public class Main {
    static int[][] arr;
    static Set<String> set;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr = new int[5][5];
        set = new HashSet<>();

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int x=0; x<5; x++) {
            for(int y=0; y<5; y++) {
                dfs(x, y, 0, String.valueOf(arr[x][y]));
            }
        }

        System.out.println(set.size());
    }

    static void dfs(int x, int y, int depth, String path) {
        if(depth == 5) {
            set.add(path);
            return;
        }

        for(int p=0; p<4; p++) {
            int nx = x + dx[p];
            int ny = y + dy[p];

            if(nx >=0 && nx < 5 && ny >=0 && ny < 5) {
                dfs(nx, ny, depth + 1, path + arr[nx][ny]);
            }
        }
    }
}
