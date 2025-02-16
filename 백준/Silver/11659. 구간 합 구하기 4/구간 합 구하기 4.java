import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n+1];

        for(int i=1; i<n+1; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int j=1; j<n+1; j++) {
            dp[j] = dp[j-1] + arr[j];
        }
        
        for(int k=0; k<m; k++) {
            int answer = 0;
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            answer = dp[y] - dp[x-1]; 
            System.out.println(answer);
        }
    }
}
