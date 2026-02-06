import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static int M;
	static int C;
	static int[][] map;
	static int[][] maxMap;
	static int max;
	static int[] temp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
		    M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			maxMap = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			makeMaxMap();
			max = 0;
			processCombination();

			System.out.println("#"+t+" "+max);
		}

	}
	
	static void makeMaxMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<=N-M; j++) {
				temp = new int[M];
				for(int k=0; k<M; k++) {
					temp[k] = map[i][j+k];
				}
				maxMap[i][j] = subset(0, 0, 0);
			}
		}
	}
	
	static int subset(int idx, int sum, int powSum) {
		if(sum > C) return 0;
		if(idx == M) return powSum;
		
		int pick = subset(idx+1, sum+temp[idx], powSum+temp[idx]*temp[idx]);
		int skip = subset(idx+1, sum, powSum);
		
		return Math.max(pick, skip);
	}

	static void processCombination() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<=N-M; j++) {
				for(int k=0; k<N; k++) {
					int start = (i==k) ? j+M : 0;
					for(int r=start; r<=N-M; r++) {
						max = Math.max(max, maxMap[i][j] + maxMap[k][r]);
					}
				}
			}
		}
	}
}
