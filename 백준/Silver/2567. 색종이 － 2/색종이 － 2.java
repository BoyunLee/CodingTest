import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[102][102];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for(int i=r+1; i<=r+10; i++) {
				for(int j=c+1; j<=c+10; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		int answer = 0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if((map[i][j] != map[i][j+1])) {
					answer++;
				}
				if((map[j][i] != map[j+1][i])) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
