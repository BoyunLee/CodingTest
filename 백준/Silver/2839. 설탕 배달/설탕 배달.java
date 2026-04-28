import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N+1];

        for(int i=0; i<=N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        if (N >= 3) dp[3] = 1;
        if (N >= 5) dp[5] = 1;

        for(int j=6; j<=N; j++) {
            if(dp[j-3] != Integer.MAX_VALUE) {
                dp[j] = Math.min(dp[j], dp[j-3] + 1);
            }

            if(dp[j-5] != Integer.MAX_VALUE) {
                dp[j] = Math.min(dp[j], dp[j-5] + 1);
            }
        }

        if(dp[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}