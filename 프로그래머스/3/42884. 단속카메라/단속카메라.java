import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int camera = Integer.MIN_VALUE;
        for(int[] route : routes) {
            
            int start = route[0];
            int end = route[1];
            
            if(camera < start) {
                answer++;
                camera = end;
            }
        }
        return answer;
    }
}