import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String A = s + s;
        for(int i=0; i<s.length(); i++) {
            String target = A.substring(i, i+s.length());
            if(isVaild(target)) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isVaild(String s) {
        Stack<Character> stack = new Stack<>();
        for (char cur : s.toCharArray()) {
            if(cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } 
                
                char c = stack.pop();
                if((c == '(' && cur != ')') ||
                   (c == '{' && cur != '}') ||
                   (c == '[' && cur != ']')) {
                    return false;
                }
            } 
        }
        return stack.isEmpty();
    }
}