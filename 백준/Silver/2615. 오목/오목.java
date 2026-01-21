import java.util.*;

public class Main {

    static int[][] map;
    static boolean win;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[19][19];
        win = false;

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] != 0 && !win) {
                	check(i, j, map[i][j]);
                }
            }
        }

        if (!win) {
            System.out.println(0);
        }
    }

    public static void check(int x, int y, int color) {

        int[] dr = {0, 1, 1, -1};
        int[] dc = {1, 0, 1, 1};

        for (int d = 0; d < 4; d++) {

            int pr = x - dr[d];
            int pc = y - dc[d];

            if (pr >= 0 && pr < 19 && pc >= 0 && pc < 19) {
                if (map[pr][pc] == color) continue;
            }

            int cnt = 1;
            int nr = x + dr[d];
            int nc = y + dc[d];

            while (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 &&
                   map[nr][nc] == color) {
                cnt++;
                nr += dr[d];
                nc += dc[d];
            }

            if (cnt == 5) {
                if (nr < 0 || nr >= 19 || nc < 0 || nc >= 19 ||
                    map[nr][nc] != color) {

                    System.out.println(color);
                    System.out.println((x + 1) + " " + (y + 1));
                    win = true;
                    return;
                }
            }
        }
    }
}
