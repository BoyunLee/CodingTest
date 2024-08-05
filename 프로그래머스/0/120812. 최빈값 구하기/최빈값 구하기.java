import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        int[] dp = new int[1000];
        for(int i=0; i<array.length; i++) {
            dp[array[i]]++;
        }
        
        int Max = 0;
        
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > Max) {
                Max = dp[i];
            }
        }

        int maxCount = 0;
        
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Max) {
                maxCount++;
                answer = i;
            }
        }

        if (maxCount > 1) {
            answer = -1;
        }

        return answer;
    }
}