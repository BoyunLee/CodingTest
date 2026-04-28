class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            
            dp[x][y] = -1;
        }
        
        dp[1][1] = 1;
        
        for(int i=1; i<= m; i++) {
            for(int j=1; j<=n; j++) {
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if(i > 1) {
                    dp[i][j] += dp[i-1][j];
                }
                
                if(j > 1) {
                    dp[i][j] += dp[i][j-1];
                }
                dp[i][j] %= 1000000007;
            }
        }
        
        answer = dp[m][n];
        
        return answer;
    }
}