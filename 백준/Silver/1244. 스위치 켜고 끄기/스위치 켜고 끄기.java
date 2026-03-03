import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			if (student == 1) {
				for (int i = cnt; i <= N; i++) {
					if (i % cnt == 0) {
						if (arr[i] == 0) {
							arr[i] = 1;
						} else {
							arr[i] = 0;
						}
					}
				}
			} else if (student == 2) {

				if (arr[cnt] == 0) {
					arr[cnt] = 1;
				} else {
					arr[cnt] = 0;
				}

				int r = cnt + 1;
				int l = cnt - 1;

				while (true) {
					if (r > N || l < 1) {
						break;
					}

					if (arr[r] == arr[l]) {
						if (arr[r] == 1) {
							arr[r] = 0;
							arr[l] = 0;
						} else {
							arr[r] = 1;
							arr[l] = 1;
						}
						r++;
						l--;
					} else {
						break;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
    
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
	}
}
