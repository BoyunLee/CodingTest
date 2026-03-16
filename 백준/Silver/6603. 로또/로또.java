import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, new int[6]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int idx, int depth, int[] temp) {
		if(depth == 6) {
			
			for(int i=0; i<6; i++) {
				sb.append(temp[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		if(idx == N) {
			return;
		}
		
		temp[depth]=arr[idx];
		
		dfs(idx+1, depth+1, temp);
		
		dfs(idx+1, depth, temp);
	}
}
