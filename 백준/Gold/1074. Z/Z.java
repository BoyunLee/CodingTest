import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int r;
	static int c;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int size = 1 << N;
		answer = 0;
		
		while(size > 1) {
			int half = size/2;
			int quadrantSize = half*half;
			
			if(r<half && c<half) {
				
			} else if(r<half && c>=half) {
				answer += quadrantSize;
				c -= half;
				
			} else if(r>=half && c<half) {
				answer += quadrantSize*2;
				r -= half;
				
			} else if(r>=half && c>=half) {
				answer += quadrantSize*3;
				r -= half;
				c -= half;
			}
			size = half;
		}
		System.out.println(answer);
	}
}
