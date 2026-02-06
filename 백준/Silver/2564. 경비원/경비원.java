import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	
	static int convert(int dir, int dist) {
		if(dir == 1) return dist;
		if(dir == 4) return N+dist;
		if(dir == 2) return N+M+(N-dist);
		return 2*N+M+(M-dist);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		int[] store = new int[K]; 
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			store[i] = convert(dir, dist);
			
		}
		
		st = new StringTokenizer(br.readLine());
		int tx = Integer.parseInt(st.nextToken());
		int ty = Integer.parseInt(st.nextToken());
		int target = convert(tx, ty);
		
		int perimeter = 2*(N+M);
		int sum = 0;
		
		for(int s : store) {
			int diff = Math.abs(target - s);
			sum += Math.min(diff, perimeter-diff);
		}
		System.out.println(sum);
	}
}