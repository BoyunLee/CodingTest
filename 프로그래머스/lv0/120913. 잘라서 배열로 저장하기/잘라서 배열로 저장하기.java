import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        int count = my_str.length() / n;
        if(my_str.length() % n != 0) {
            count += 1;
        }
        String[] answer = new String[count];
        
        for(int i=0; i<count; i++) {
            int startIdx = i * n;
            int endIdx = Math.min(startIdx + n, my_str.length());
            answer[i] = my_str.substring(startIdx, endIdx);
        }
        return answer;
    }
}