import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	static int K;
	static int[][] magnet;
	static int[] dir;
	static int[] score = {1, 2, 4, 8};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			K = Integer.parseInt(br.readLine());
			magnet = new int[4][8];
			
			
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int d = Integer.parseInt(st.nextToken());
				
				dir = new int[4];
				dir[x] = d;
				
				for (int i = x; i < 3; i++) {
				    if (magnet[i][2] != magnet[i+1][6]) {
				        dir[i+1] = -dir[i];
				    } else {
				        break;
				    }
				}

				for (int i = x; i > 0; i--) {
				    if (magnet[i][6] != magnet[i-1][2]) {
				        dir[i-1] = -dir[i];
				    } else {
				        break;
				    }
				}
				
				for(int i=0; i<4; i++) {
					if(dir[i] != 0) {
						rotate(i, dir[i]);
					}
				}
			}
			
			int answer = 0;
			for(int i=0; i<4; i++) {
				if(magnet[i][0] == 1) {
					answer += score[i];
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
	
	static void rotate(int i, int d) {
		if(d == 1) {
			int temp = magnet[i][7];
			for(int j=7; j>0; j--) {
				magnet[i][j] = magnet[i][j-1];
			}
			magnet[i][0] = temp;
		} else if(d == -1) {
			int temp = magnet[i][0];
			for(int j=0; j<7; j++) {
				magnet[i][j] = magnet[i][j+1];
			}
			magnet[i][7] = temp;
		}
	}
}