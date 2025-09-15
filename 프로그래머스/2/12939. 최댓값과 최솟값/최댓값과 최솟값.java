import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] array = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(String a : array) {
            int number = Integer.parseInt(a);
            if(number >= max) {
                max = number;
            }
            
            if(number < min) {
                min = number;
            }  
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}