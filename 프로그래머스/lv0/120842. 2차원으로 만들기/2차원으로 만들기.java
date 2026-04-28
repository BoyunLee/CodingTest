import java.util.*;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int m = num_list.length / n;
        int[][] answer = new int[m][n];
        int number = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                answer[i][j] = num_list[number];
                number++;
            }
        }
        return answer;
    }
}