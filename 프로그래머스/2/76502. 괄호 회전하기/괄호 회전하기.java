import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
    //     // 회전 대신 문자열 두 번 반복하기
    //     String A = s + s; 
    //     for(int i=0; i<s.length(); i++) {
    //          String rotatedStr = A.substring(i, i + s.length());
    //         if (isValid(rotatedStr)) {
    //             answer++;
    //         }
    //     }
    //     return answer;
    // }

        // 문자열 회전
        for (int i = 0; i < s.length(); i++) {
            String rotatedStr = s.substring(i) + s.substring(0, i);
            if (isValid(rotatedStr)) {
                answer++;
            }
        }
        return answer;
    }

    // 괄호 짝 검사 메서드
    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!matches(top, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // 괄호 짝 확인 메서드
    private boolean matches(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}