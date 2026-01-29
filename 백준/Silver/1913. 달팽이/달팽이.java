import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		int r = N/2;
		int c = N/2;
		int tr = r+1;
		int tc = c+1;
		
		int dr[] = {-1, 0, 1, 0};
		int dc[] = {0, 1, 0, -1};
		
		int num = 1;
		arr[r][c] = num++;
		
		int step = 1;
		
		outer:
		while(num <= N*N) {
			for(int d=0; d<4; d++) {
				for(int i=0; i<step; i++) {
					r += dr[d];
					c += dc[d];
					
					if (r >= 0 && r < N && c >= 0 && c < N) {
		                if (num == target) {
		                    tr = r + 1;
		                    tc = c + 1;
		                }
		                arr[r][c] = num++;
		            }
		            
		            if (num > N * N) break outer;
		        }
		        if (d == 1 || d == 3) step++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        sb.append(tr).append(' ').append(tc);
        System.out.print(sb);
	}
}