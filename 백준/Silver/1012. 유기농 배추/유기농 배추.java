import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int M, N, K, cnt;
	static int[][] map;
	static Queue<int[]> queue;
	static int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cnt = 0;

			map = new int[N][M];
			queue = new ArrayDeque<>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				map[row][col] = 1;
			}

			// bfs 시뮬레이션
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}

			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString().trim());

	}

	static void bfs(int row, int col) {
		queue.offer(new int[] { row, col });
		map[row][col] = 0;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + moves[i][0];
				int nc = c + moves[i][1];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (map[nr][nc] == 0)
					continue;

				map[nr][nc] = 0;
				queue.offer(new int[] { nr, nc });
			}

		}
	}

}