import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = 1;
        }
        
        for(int j=0; j<lost.length; j++) {
            dp[lost[j]-1] = 0;
        }
        
        for(int k=0; k<reserve.length; k++) {
            dp[reserve[k]-1] += 1;
        }
        
        for(int a=0; a<n; a++) {
            if(dp[a] == 0) {
                if(a-1>=0 && dp[a-1] == 2) {
                    dp[a] = 1;
                    dp[a-1] = 1;
                } else if(a+1<n && dp[a+1] == 2) {
                    dp[a] = 1;
                    dp[a+1] = 1;
                }
            }
        }
        
        for(int c=0; c<n; c++) {
            if(dp[c] >= 1) answer++;
        }
        
        return answer;
    }
}