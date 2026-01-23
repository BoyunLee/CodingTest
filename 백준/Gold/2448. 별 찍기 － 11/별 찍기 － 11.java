import java.io.*;

public class Main {
	static int N;
	static int[][] star;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		star = new int[N][2*N];
		
		star(0, 0, N);
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<2*N; j++) {
				sb.append(star[i][j]==1?"*":" ");
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}
	
	private static void star(int r, int c, int n) {
		if(n==3) {
			for(int i=0; i<3; i++) {
				for(int j=0; j<5; j++) {
					if(i==0 && j==2) star[r+i][c+j]=1;
					else if(i==1 && (j==1 || j==3)) star[r+i][c+j]=1;
					else if(i==2) star[r+i][c+j]=1;
				}
			}
		} else {
			star(r, c+n/2, n/2);
			star(r+n/2, c, n/2);
			star(r+n/2, c+n, n/2);
		}
	}
}