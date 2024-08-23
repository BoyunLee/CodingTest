import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] coins = new int[n];
        
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        
        int max = 10001; 
        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int amount = coin; amount <= k; amount++) {
                if (dp[amount - coin] != max) {
                    dp[amount] = Math.min(dp[amount], dp[amount - coin] + 1);
                }
            }
        }
        
        if (dp[k] == max) {
            System.out.println(-1); 
        } else {
            System.out.println(dp[k]);
        }
        scanner.close();
    }
}
