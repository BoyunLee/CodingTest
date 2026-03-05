import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static int[] math;
	static int max;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		math = new int[4];
		for(int i=0; i<4; i++) {
			math[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		dfs(1, arr[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void dfs(int idx, int result){

	    if(idx == N){
	        max = Math.max(max, result);
	        min = Math.min(min, result);
	        return;
	    }

	    for(int i=0; i<4; i++){
	        if(math[i] > 0){

	        	math[i]--;

	            if(i==0) dfs(idx+1, result + arr[idx]);
	            if(i==1) dfs(idx+1, result - arr[idx]);
	            if(i==2) dfs(idx+1, result * arr[idx]);
	            if(i==3) dfs(idx+1, result / arr[idx]);

	            math[i]++;
	        }
	    }
	}
}
