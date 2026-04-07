import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] V = new int[N+1];
			int[] C = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				V[i] = Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[N+1][K+1];
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=K; j++) {
					dp[i][j] = dp[i-1][j];
					
					if(j >= V[i]) {
						dp[i][j] = Math.max(dp[i][j], dp[i-1][j-V[i]]+C[i]);
					}
				}
			}
			System.out.println("#"+t+" "+dp[N][K]);
		}
	}
}
