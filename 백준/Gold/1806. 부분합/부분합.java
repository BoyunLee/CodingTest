import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int i=0;
		int j=0;
		int minLen = Integer.MAX_VALUE;
		
		while(true) {
			if(sum<S) {
				if(j == N) break;
				sum += arr[j];
				j++;
			} else if(sum>=S) {
				minLen = Math.min(minLen, j-i);
				sum -= arr[i];
				i++;
			}
		}
		
		System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
	}
}