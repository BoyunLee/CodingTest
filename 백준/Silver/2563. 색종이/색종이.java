import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		int[][] map = new int[101][101];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			for(int r=R; r<R+10; r++) {
				for(int c=C; c<C+10; c++) {
					if(map[r][c] == 1) {
						continue;
					}
					map[r][c] = 1;
				}
			}
		}
		
		int answer = 0;
		
		for(int r=0; r<101; r++) {
			for(int c=0; c<101; c++) {
				if(map[r][c] == 1) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}