import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	static int[] arr;
	static int maxHeight;
	static int answer;
	static int one; // 홀
	static int two; // 짝

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			one = 0;
			two = 0;
			maxHeight = 0;
			answer = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(arr[i], maxHeight);
			}
			
			for(int i=0; i<N; i++) {
				int diff = maxHeight - arr[i];
			    one += diff % 2;
			    two += diff / 2;
			}
			
			while (two > one + 1) {
			    two -= 1;
			    one += 2;
			}

			if (one > two) {
			    answer = 2 * one - 1;
			} else {
			    answer = 2 * two;
			}
			
			System.out.println("#"+t+" "+answer);
		}
	} 
}
