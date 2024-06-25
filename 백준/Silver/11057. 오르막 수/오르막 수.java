import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 길이가 1 -> 모두 자기 자신이라서 오르막 수는 1개씩 있음
		long[][] dp = new long[N + 1][10];
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		// 길이가 i일 때 오르막 수 구하기
		for (int i = 2; i <= N; i++) {
			// 끝 자리가 j일 때 오르막 수 구하기
			for (int j = 0; j < 10; j++) {
				// 이전 길이(i-1)일 때 끝 자리가 j보다 작은 모든 수들을 더함
				for (int k = 0; k <= j; k++) {
					dp[i][j] += dp[i-1][k];
				}
				dp[i][j] %= 10007;
			}
		}
		
        // 길이가 N이고 모든 자리 수가 오르막 수일 경우의 수를 구함
		long answer = 0;
		for(int i=0; i<10; i++) {
			answer += dp[N][i];
		}
		
		System.out.println(answer % 10007);
        
    }
}