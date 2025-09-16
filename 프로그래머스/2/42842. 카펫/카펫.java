import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for(int i=1; i<total; i++) {
            int j = total / i;
            if(total % i == 0 && i >= j) {
                if((2*i + 2*j) == brown + 4) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;
    }
}