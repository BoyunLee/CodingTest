import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static long K;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		long[] w = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			w[i] = Long.parseLong(st.nextToken());
		}
		
		if (M <= 1) {
            System.out.println("YES");
            return;
		}
		
		boolean[] blocked = new boolean[N+1]; 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int idx;
			if((x==1 && y==N) || (x==N && y==1)) {
				idx = N;
			}  else {
				idx = Math.min(x, y);
			}
			blocked[idx] = true;
		}
		
        int start = 1;
        for (int i = 1; i <= N; i++) {
            if (blocked[i]) {
                start = (i % N) + 1;
                break;
            }
        }

        long sum = 0;
        long curMin = Long.MAX_VALUE;

        int cur = start;
        for (int step = 0; step < N; step++) {
            curMin = Math.min(curMin, w[cur]);

            if (blocked[cur]) {
                sum += curMin;
                if (sum > K) {
                    System.out.println("NO");
                    return;
                }
                curMin = Long.MAX_VALUE;
            }
            cur = (cur % N) + 1;
        }
        System.out.println(sum <= K ? "YES" : "NO");
    }
}
