import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] object = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			object[i][0] = Integer.parseInt(st.nextToken());
			object[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			int W = object[i][0];
			int V = object[i][1];
			
			for(int j=0; j<=K; j++) {				
				dp[i][j] = dp[i-1][j];
				
				if(j >= W) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-W] + V);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}