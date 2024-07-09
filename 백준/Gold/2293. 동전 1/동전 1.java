import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        int[] coins = new int[n];

        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
            sc.nextLine();
        }

        Arrays.sort(coins);

        int[] dp = new int[k+1];
        dp[0] = 1;

        for(int i=0; i<n; i++){
            for(int j=1; j<=k; j++){
                if (j >= coins[i]){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        System.out.println(dp[k]);
        sc.close();
    }
}
