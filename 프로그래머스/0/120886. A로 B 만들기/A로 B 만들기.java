import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        
        char[] arraybefore = before.toCharArray();
        char[] arrayafter = after.toCharArray();
        
        Arrays.sort(arraybefore);
        Arrays.sort(arrayafter);
        
        if(Arrays.equals(arraybefore, arrayafter)) {
            answer = 1;
        }
        
        return answer;
    }
}