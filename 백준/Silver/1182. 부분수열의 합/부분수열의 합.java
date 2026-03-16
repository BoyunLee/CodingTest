import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int S;
	static int[] arr;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		count = 0;
		dfs(0, 0);
		if(S == 0) {
			count -= 1;
		}
		System.out.println(count);
	}
	
	static void dfs(int idx, int sum) {
		if(idx == N) {
			if(sum == S) {
				count++;
				return;
			}
			return;
		}
		
		dfs(idx+1, sum + arr[idx]);
		
		dfs(idx+1, sum);
	}
}