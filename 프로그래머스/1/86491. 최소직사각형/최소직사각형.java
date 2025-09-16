import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int n = sizes.length;
        
        int[] max = new int[n];
        int[] min = new int[n];
        
        for(int i=0; i<n; i++) {
            int a = sizes[i][0];
            int b = sizes[i][1];
            
            if(a >= b) {
                max[i] = a;
                min[i] = b;
            } else {
                max[i] = b;
                min[i] = a;
            }
        }
        
        Arrays.sort(max);
        Arrays.sort(min);
        
        answer = max[n-1] * min[n-1];
        
        return answer;
    }
}