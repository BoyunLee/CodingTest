import java.util.*;

public class Main {
	
	static int N, M;
	
	static int convert(int dir, int dist) {
		if(dir == 1) return dist;
		if(dir == 4) return N+dist;
		if(dir == 2) return N+M+(N-dist);
		return 2*N+M+(M-dist);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int K = sc.nextInt();
		
		int[] store = new int[K]; 
		
		for(int i=0; i<K; i++) {
			int dir = sc.nextInt();
			int dist = sc.nextInt();
			store[i] = convert(dir, dist);
			
		}
		
		int tx = sc.nextInt();
		int ty = sc.nextInt();
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
