import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String number = my_string.replaceAll("[^0-9]", "");

        for(int i=0; i<number.length(); i++) {
            answer += Character.getNumericValue(number.charAt(i));
        }

        return answer;
    }
}