import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        for(char c : my_string.toCharArray()) {
            if(answer.indexOf(String.valueOf(c)) == -1) {
                answer.append(c);
            }
        } 
        return answer.toString();
    }
}