import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] nums;
	static int[] result;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		result = new int[M];
		
		dfs(0, 0);
		
		System.out.println(sb);
	}
	
	static void dfs(int depth, int start) {
		
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int prev = -1;
		for(int i=start; i<N; i++) {
			if(nums[i] == prev) continue;
			
			result[depth] = nums[i];
			prev = nums[i];
			dfs(depth+1, i);
		}
	}
}