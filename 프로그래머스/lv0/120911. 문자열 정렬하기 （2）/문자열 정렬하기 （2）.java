import java.util.*;

class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        
        String[] arr = my_string.split("");

        Arrays.sort(arr);
        
        String answer = String.join("",arr);
        return answer;
    }
}