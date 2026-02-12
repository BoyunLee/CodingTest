import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = 0;
		
		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		
		Arrays.sort(trees);
		
		long left = 0;
		long right = max;
		long answer = 0;
		while(left <= right) {
			long mid = (left+right)/2;
			
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(trees[i] > mid) {
					sum += (trees[i] - mid);
				}
			}
			
			if(sum >= M) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid -1;
			}
		}
		System.out.println(answer);
	}
}
