import java.util.*;

class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        String chage = "";
        for(int i=e; i>=s; i--) {
            chage += my_string.charAt(i);
        }
        answer = my_string.substring(0, s) + chage + my_string.substring(e+1);
        return answer;
    }
}