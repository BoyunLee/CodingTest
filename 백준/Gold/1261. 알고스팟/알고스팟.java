import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] miro;
    static int[][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        miro = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        zeroOneBfs();

        System.out.println(dist[N - 1][M - 1]);
    }

    static void zeroOneBfs() {
        Deque<Node> deque = new ArrayDeque<>();
        dist[0][0] = 0;
        deque.addFirst(new Node(0, 0));

        while (!deque.isEmpty()) {
            Node cur = deque.pollFirst();
            int r = cur.r;
            int c = cur.c;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                int nextCost = dist[r][c] + miro[nr][nc];

                if (nextCost < dist[nr][nc]) {
                    dist[nr][nc] = nextCost;

                    if (miro[nr][nc] == 0) {
                        deque.addFirst(new Node(nr, nc));
                    } else {
                        deque.addLast(new Node(nr, nc));
                    }
                }
            }
        }
    }
}