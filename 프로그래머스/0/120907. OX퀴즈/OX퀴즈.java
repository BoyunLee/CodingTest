import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i=0; i<quiz.length; i++) {
            String[] parts = quiz[i].split(" ");
            int x = Integer.parseInt(parts[0]);
            String s = parts[1];
            int y = Integer.parseInt(parts[2]);
            int z = Integer.parseInt(parts[4]);
            
            int result = 0;
            if(s.equals("+")) {
                result = x + y;
            } else {
                result = x - y;
            }
            
            if(result == z) {
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }
        }
        return answer;
    }
}