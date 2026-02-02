import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] sour;
	static int[] bitter;
	static long answer;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		answer = Integer.MAX_VALUE;
		
		dfs(0, 1, 0, false);
		System.out.println(answer);
		
	}
	
	static void dfs(int idx, long sumSour, long sumBitter, boolean used) {
		if(idx == N) {
			if(used) {
				long result = Math.abs(sumSour - sumBitter);
				answer = Math.min(answer, result);
			}
			return;
		}
		dfs(idx+1, sumSour*sour[idx], sumBitter+bitter[idx], true);
		dfs(idx+1, sumSour, sumBitter, used);
	}
}