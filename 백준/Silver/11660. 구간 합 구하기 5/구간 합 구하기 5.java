import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		int[][] sum = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i-1][j-1] = Integer.parseInt(st.nextToken());
				sum[i][j] = map[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1]; 
			}
		}
		
		for(int i=0; i<M; i++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int nr = Integer.parseInt(st.nextToken());
			int nc = Integer.parseInt(st.nextToken());
			
			answer = sum[nr][nc] - sum[sr-1][nc] - sum[nr][sc-1] + sum[sr-1][sc-1];
			System.out.println(answer);
		}
	}
}
