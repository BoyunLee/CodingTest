import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] item = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dist = new int[n+1][n+1];
		int INF = 1000000000;

        for(int i=1;i<=n;i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            dist[a][b] = l;
            dist[b][a] = l;
        }
		
        for(int k=1; k<=n; k++) {
        	for(int i=1; i<=n; i++) {
        		for(int j=1; j<=n; j++) {
        			if (dist[i][k] != INF && dist[k][j] != INF) {
        			    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        			}
        		}
        	}
        }
        
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
        	int sum = 0;
        	
        	for(int j=1; j<=n; j++) {
        		if(dist[i][j] <= m) {
        			sum += item[j];
        		}
        	}
        	answer = Math.max(answer, sum);
        }
		System.out.println(answer);
	}
}