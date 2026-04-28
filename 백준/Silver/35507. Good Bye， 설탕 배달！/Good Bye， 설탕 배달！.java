import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			boolean success = true;
	
			int N = Integer.parseInt(br.readLine());

			long totalA = 0;
			long totalB = 0;
			long totalC = 0;
			long totalP = 0;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				long a = Long.parseLong(st.nextToken());
				long b = Long.parseLong(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				long p = Long.parseLong(st.nextToken());
				
				if (!success) {
			        continue;
			    }
				
				long sum = 0;
				if(a-totalA > 0) {
					sum += a-totalA;
				}
				if(b-totalB > 0) {
					sum += b-totalB;
				}
				if(c-totalC > 0) {
					sum += c-totalC;
				}
				
				if(totalP+sum+1 <= p) {
					totalA = Math.max(totalA, a);
					totalB = Math.max(totalB, b);
					totalC = Math.max(totalC, c);
					totalP += (sum+1);
				} else {
					success = false;
				}
			}
			
			if(success) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
