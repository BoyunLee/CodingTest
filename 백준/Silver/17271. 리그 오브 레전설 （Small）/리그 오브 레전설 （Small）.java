import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] dp = new int[N+1];
		dp[0] = 1;
		
		int K = 1000000007;
		
		for(int i=1; i<=N; i++) {
			dp[i] = dp[i-1];
			if(i >= M) {
				dp[i] = (dp[i] + dp[i-M]) % K;
			} else {
				dp[i] %= K;
			}
		}
		System.out.println(dp[N] % K);
	}
}