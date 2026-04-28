public class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] dp = new int[201]; 

        for (int[] line : lines) {
            int start = line[0];
            int end = line[1];
            for (int i = start; i < end; i++) { 
                dp[i + 100]++;  
            }
        }
        
        for (int count : dp) {
            if (count >= 2) {
                answer++;
            }
        }

        return answer;
    }
}
