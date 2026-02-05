import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] magnet;
	static int[] score = {1, 2, 4, 8};
	static int[] direction;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		magnet = new int[4][8];
		for(int i=0; i<4; i++) {
			String line = br.readLine();
			for(int j=0; j<8; j++) {
				magnet[i][j] = line.charAt(j) - '0';
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int d =  Integer.parseInt(st.nextToken());
			direction = new int[4];
			direction[num] = d;
			
			for(int i=num; i>0; i--) {
				if(magnet[i][6] != magnet[i-1][2]) {
					direction[i-1] = -direction[i];
				} else {
					break;
				}
			}
			
			for(int i=num; i<3; i++) {
				if(magnet[i][2] != magnet[i+1][6]) {
					direction[i+1] = -direction[i];
				} else {
					break;
				}
			}
			
			for(int i=0; i<4; i++) {
				if(direction[i] != 0) {
					move(i, direction[i]);
				}
			}
			
		}
		
		int answer = 0;
		for(int i=0; i<4; i++) {
			if(magnet[i][0] == 1) {
				answer += score[i];
			}
		}
		
		System.out.println(answer);

	}
	
	static void move(int num, int d) {
		if(d == 1) {
			int temp = magnet[num][7];
			for(int i=7; i>0; i--) {
				magnet[num][i] = magnet[num][i-1];
			}
			magnet[num][0] = temp;
		} else if(d == -1) {
			int temp = magnet[num][0];
			for(int i=0; i<7; i++) {
				magnet[num][i] = magnet[num][i+1];
			}
			magnet[num][7] = temp;
		}
	}

}
