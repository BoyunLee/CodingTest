import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M =  Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			int[][] sum = new int[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					map[i-1][j-1] = Integer.parseInt(st.nextToken());
					sum[i][j] = map[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
				}
			}
			
			int answer = 0;
			
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					int area = sum[i+M][j+M] - sum[i][j+M] - sum[i+M][j] + sum[i][j];
					answer = Math.max(answer, area);
				}
			}
			System.out.println("#"+t+" "+answer);
		}
    }
}