import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String number1 = String.valueOf(a) + String.valueOf(b);
        String number2 = String.valueOf(b) + String.valueOf(a);
        answer = Math.max(Integer.parseInt(number1), Integer.parseInt(number2));
        
        return answer;
    }
}