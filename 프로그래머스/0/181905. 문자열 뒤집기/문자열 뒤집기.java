import java.util.*;

class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        for(int i=0; i<s; i++) {
            answer += my_string.charAt(i);
        }
        
        for(int j=e; j>=s; j--) {
            answer += my_string.charAt(j);
        }
        
        for(int k=e+1; k<my_string.length(); k++) {
            answer += my_string.charAt(k);
        }
        
        return answer;
    }
}