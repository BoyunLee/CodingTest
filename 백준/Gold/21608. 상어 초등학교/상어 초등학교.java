import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[][] room;
	static int[][] like;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int M = N*N;
		like = new int[M+1][4];
		int[] order = new int[M];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			order[i] = idx;
			for(int j=0; j<4; j++) {
				like[idx][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		room = new int[N][N];
		for(int i=0; i<M; i++) {
			int num = order[i];
			
			int[] xy = check(num);
			room[xy[0]][xy[1]] = num;
		}
		
		answer = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				happy(i, j);
			}
		}
		
		System.out.println(answer);
	}
	
	static int[] check(int num) {
		int maxGood = -1;
		int maxEmp = -1;
		int x = 0;
		int y = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int r = i;
				int c = j;
				int good = 0;
				int emp = 0;
				
				if(room[r][c] != 0) continue;
				
				for(int d=0; d<4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					
					if(nr<0 || nc<0 || nr>=N || nc>= N) continue;
					
					if(room[nr][nc] == 0) {
						emp++;
					} else{
						for(int g=0; g<4; g++) {
							if(room[nr][nc] == like[num][g]) {
								good++;
							}
						}
					}
				}
				
				if(good > maxGood) {
					x = r;
					y = c;
					maxGood = good;
					maxEmp = emp;
				} else if((good == maxGood && maxEmp < emp)) {
					x = r;
					y = c;
					maxEmp = emp;
				} else if((good == maxGood && maxEmp == emp && y > c)) {
					x = r;
					y = c;
				} else if((good == maxGood && maxEmp == emp && y == c && x > r)) {
					x = r;
					y = c;
				}
			}
		}
		int[] maxXY = {x, y};
		return maxXY;
	}
	
	static void happy(int r, int c) {
		int cnt = 0;
		int student = room[r][c];
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			
			if(room[nr][nc] != 0) {
				for(int g=0; g<4; g++) {
					if(room[nr][nc] == like[student][g]) {
						cnt++;
					}
				}
			}
		}
		
		if(cnt == 0) {
			answer += 0;
		} else if(cnt == 1) {
			answer += 1;
		} else if(cnt == 2) {
			answer += 10;
		} else if(cnt == 3) {
			answer += 100;
		} else if(cnt == 4) {
			answer += 1000;
		}
	}
}
