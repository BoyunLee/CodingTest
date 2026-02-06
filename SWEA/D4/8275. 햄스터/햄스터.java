import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static int X;
	static int M;
	static int[] arr;
	static int[] best;
	static int[][] cond;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			best = new int[N];
			cond = new int[M][3];
			answer = -1;
			
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				cond[m][0] = Integer.parseInt(st.nextToken())-1;
				cond[m][1] = Integer.parseInt(st.nextToken())-1;
				cond[m][2] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0);
			
			if(answer == -1) {
				System.out.println("#"+t+" "+-1);
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append("#").append(t);
				for(int i=0; i<N; i++) {
					sb.append(" ").append(best[i]);
				}
				System.out.println(sb);
			}
		}

	}
	
	static void dfs(int idx) {
		if(idx == N) {
			if(checkAll()) {
				int sum = totalSum();
				if(sum > answer) {
					answer = sum;
					for (int i = 0; i < N; i++) {
					    best[i] = arr[i];
					}
				}
			}
			return;
		}
		
		for(int v=0; v<=X; v++) {
			arr[idx] = v;
			
			if(possible(idx)) {
				dfs(idx+1);
			}
		}
	}

	static boolean possible(int idx) {
		for(int i=0; i<M; i++) {
			int l = cond[i][0];
	        int r = cond[i][1];
	        int s = cond[i][2];
	        
	        int cur = 0;
	        int remain = 0;
	        
	        for(int j=l; j<=r; j++) {
	        	if(j <= idx) {
	        		cur += arr[j];
	        	} else {
	        		remain++;
	        	}
	        }
	        
	        if(cur > s) {
	        	return false;
	        }
	        
	        if(cur + remain*X < s) {
	        	return false;
	        }
		}
		return true;
	}
	
	static boolean checkAll() {
		for(int i=0; i<M; i++) {
			int l = cond[i][0];
	        int r = cond[i][1];
	        int s = cond[i][2];
	        
	        int sum = 0;
	        for(int j=l; j<=r; j++) {
	        	sum += arr[j];
	        }
	        	        
	        if(sum != s) {
	        	return false;
	        }
		}
		return true;
	}
	
	private static int totalSum() {
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
