import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x = 0;
        int y = 0;
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(i == j) {
                    continue;
                }
                if(dots[i][0] == dots[j][0]) {
                    y = Math.abs(dots[i][1] - dots[j][1]);
                }
                if(dots[i][1] == dots[j][1]) {
                    x = Math.abs(dots[i][0] - dots[j][0]);
                }
            }
        }   
        answer = x*y;
        return answer;
    }
}