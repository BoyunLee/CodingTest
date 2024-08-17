import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        for(char c : my_string.toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                continue;
            } else {
                answer.append(c);
            }
        }
        return answer.toString();
    }
}