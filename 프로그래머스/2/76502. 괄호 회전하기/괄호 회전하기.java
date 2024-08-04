import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String A = s + s;
        for(int i=0; i<s.length(); i++) {
            String target = A.substring(i, i + s.length());
            if(isVaild(target)) {
                answer ++;
            }
        }
        
        return answer;
    }
    
    private boolean isVaild(String s) {
        Stack<Character> stack = new Stack<>();

        for (char current : s.toCharArray()) {
            if (current == '(' ||  current == '{' ||  current == '[') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char target = stack.pop();
                if ((target == '(' && current != ')') || 
                    (target == '{' && current != '}') || 
                    (target == '[' && current != ']')) {
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}