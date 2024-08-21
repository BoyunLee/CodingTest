import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] words = s.split(" ");
        
        for(int i=0; i<words.length; i++) {
            if(words[i].equals("Z")) {
                words[i] = "0";
                words[i-1] = "0";
            } 
        }
        
        int[] numbers = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            numbers[i] = Integer.parseInt(words[i]);
            answer += numbers[i];
        }
        return answer;
    }
}