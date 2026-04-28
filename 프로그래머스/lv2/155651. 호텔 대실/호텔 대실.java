import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] dp = new int[1440];
        for(int i=0; i<1440; i++) {
            dp[i] = 0;
        }
        
        for(String[] time:book_time) {
            int[] format = new int[2];
            
            for(int i=0; i<2; i++) {
                String[] parts = time[i].split(":");
                int hour = Integer.parseInt(parts[0]);
                int min = Integer.parseInt(parts[1]);
                format[i] = hour*60 + min;
            }
            
            for(int s=format[0]; s < Math.min(1440, format[1] + 10); s++) {
                dp[s] += 1;
            }
        }
        
        for (int x : dp) {
            answer = Math.max(answer, x);
        }
        
        return answer;
    }
}