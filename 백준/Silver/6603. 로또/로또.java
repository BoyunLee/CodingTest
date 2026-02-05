import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static boolean[] visited;
	static int[] answer;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) {
				break;
			}
			
			arr = new int[N];
			visited = new boolean[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			answer = new int[6];
			dfs(0, 0);
			System.out.println();
		}

	}
	
	static void dfs(int idx, int cnt) {
		if(cnt == 6) {
			for (int i = 0; i < 6; i++) {
		        System.out.print(answer[i]);
		        if (i < 5) System.out.print(" ");
		    }
		    System.out.println();
		    return;
		}
		
		if(idx == N) return;
		
		answer[cnt] = arr[idx];
		dfs(idx+1, cnt+1);
		
		dfs(idx+1, cnt);
	} 
}