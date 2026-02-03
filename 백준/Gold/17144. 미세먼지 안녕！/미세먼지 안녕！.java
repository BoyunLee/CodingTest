import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static int T;
	static int[][] arr;
	static int[][] next;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int up;
	static int down;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		next = new int[R][C];
		
		up = -1;
		down = -1;
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					next[i][j] = -1;
					if (up == -1) up = i;
		            else down = i;
				}
			}
		}
		
		for(int i=0; i<T; i++) {
			next = new int[R][C];
			next[up][0] = -1;
		    next[down][0] = -1;
		    
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(arr[r][c] > 0) {
						spread(r, c);
					}
					
				}
			}
			
			arr = next;
			
			cycleUp();
			cycleDown();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] == -1) continue;
				answer += arr[i][j];
			}
		}
		
		System.out.println(answer);
		
	}
	
	static void spread(int r, int c) {
		int amount = arr[r][c] / 5;
		int cnt = 0;

		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
			if (arr[nr][nc] == -1) continue;
			
			next[nr][nc] += amount;
			cnt++;
		}
		next[r][c] += arr[r][c] - amount*cnt;
	}
	
	static void cycleUp() {
		int s = up;
		
		for (int r = s-1; r >= 1; r--) arr[r][0] = arr[r-1][0];
        for (int c = 0; c <= C - 2; c++) arr[0][c] = arr[0][c+1];
        for (int r = 0; r <= s - 1; r++) arr[r][C-1] = arr[r+1][C-1];
        for (int c = C - 1; c >= 2; c--) arr[s][c] = arr[s][c-1];
        arr[s][1] = 0;
		
	}
	
	static void cycleDown() {
		int s = down;
		
		for (int r = s + 1; r <= R - 2; r++) arr[r][0] = arr[r+1][0];
        for (int c = 0; c <= C - 2; c++) arr[R-1][c] = arr[R-1][c+1];
        for (int r = R-1; r >= s + 1; r--) arr[r][C-1] = arr[r-1][C-1];
        for (int c = C-1; c >= 2; c--) arr[s][c] = arr[s][c-1];
        arr[s][1] = 0;
	}

}
