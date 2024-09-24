import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        int[][] sum = new int[score.length][2];
        for(int i=0; i<score.length; i++) {
            sum[i][0] = i;
            sum[i][1] = score[i][0] + score[i][1];
        }
        
        Arrays.sort(sum, (a, b) -> b[1] - a[1]);
        
        int rank = 1;
        answer[sum[0][0]] = rank;
        
        for(int i=1; i<sum.length; i++) {
            if(sum[i][1] == sum[i-1][1]) {
                answer[sum[i][0]] = rank;
            } else {
                // Otherwise, update the rank
                rank = i + 1;
                answer[sum[i][0]] = rank;
            }
        }
        return answer;
    }
}