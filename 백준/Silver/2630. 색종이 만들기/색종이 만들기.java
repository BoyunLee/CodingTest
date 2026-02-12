import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static int blue;
	static int white;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		blue = 0;
		white = 0;
		cut(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void cut(int r, int c, int n) {
		int size = 0;
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				if(map[i][j] == 1) {
					size++;
				}
			}
		}
		
		if(size == n*n) {
			blue++;
		} else if(size == 0) {
			white++;
		} else {
			cut(r, c, n/2);
			cut(r+n/2, c, n/2);
			cut(r, c+n/2, n/2);
			cut(r+n/2, c+n/2, n/2);
		}
	}
}
