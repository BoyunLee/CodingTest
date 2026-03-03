import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = 0;

			for (int r = 0; r < N; r++) {
				int cnt = 0;
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == 1) {
						cnt++;
					} else {
						if (cnt == K) {
							answer++;
						}
						cnt = 0;
					}
				}
				if (cnt == K) {
					answer++;
				}
			}

			for (int c = 0; c < N; c++) {
				int cnt = 0;
				for (int r = 0; r < N; r++) {
					if (arr[r][c] == 1) {
						cnt++;
					} else {
						if (cnt == K) {
							answer++;
						}
						cnt = 0;
					}
				}
				if (cnt == K) {
					answer++;
				}
			}

			System.out.println("#" + t + " " + answer);
		}
	}
}
