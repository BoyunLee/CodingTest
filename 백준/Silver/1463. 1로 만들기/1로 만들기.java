import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws  IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(bottomUp(n));
	}
	
	static int bottomUp(int num) {
        int[] dp = new int[num + 1];
        
        for (int i = 2; i <= num; i++) {

            // 우선 1을 뺀 경우의 수를 현재의 dp[i]에 저장
            dp[i] = dp[i - 1] + 1;
            
            // 2로 나누어 떨어질 때
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            
            // 3으로 나누어 떨어질 때
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        return dp[num];
    }    
}
