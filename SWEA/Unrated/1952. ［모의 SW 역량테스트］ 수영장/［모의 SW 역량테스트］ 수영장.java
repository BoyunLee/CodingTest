import java.io.BufferedReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int[] cost = new int[4];
            int[] date = new int[12];
            int[] dp = new int[12];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<12; i++) {
                date[i] = Integer.parseInt(st.nextToken());
            }

            dp[0] = Math.min(cost[0]*date[0], cost[1]);

            for(int i=1; i<12; i++) {
                dp[i] = dp[i-1] + Math.min(cost[0]*date[i], cost[1]);
                if(i <= 2) {
                    dp[i] = Math.min(dp[i], cost[2]);
                } else if(i > 2) {
                    dp[i] = Math.min(dp[i], dp[i-3] + cost[2]);
                }
            }

            System.out.println("#"+t+" "+Math.min(cost[3], dp[11]));
        }
    }
}
