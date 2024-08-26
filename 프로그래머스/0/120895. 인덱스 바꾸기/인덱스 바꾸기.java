class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder answer = new StringBuilder(my_string);
        
        char temp = answer.charAt(num1);
        answer.setCharAt(num1, answer.charAt(num2));
        answer.setCharAt(num2, temp);
        
        return answer.toString();
    }
}