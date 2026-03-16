import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, S, totalCnt;
	static int[] stones;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		totalCnt = 0;
		stones = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}

		subset(0, 0);
		System.out.println(totalCnt);

	}

	static void subset(int idx, int cnt) {
		if (idx == N) {
			if (cnt == 0)
				return;
			int total = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					total += stones[i];
				}
			}
			if (total == S)
				totalCnt++;
			return;
		}

		visited[idx] = true;
		subset(idx + 1, cnt + 1);
		visited[idx] = false;
		subset(idx + 1, cnt);

	}
}