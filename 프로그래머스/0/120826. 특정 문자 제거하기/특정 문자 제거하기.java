class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder answer = new StringBuilder();
        char letterChar = letter.charAt(0);
        for(char c : my_string.toCharArray()) {
            if(c == letterChar) {
                continue;
            } else {
                answer.append(c);
            }
        }
        return answer.toString();
    }
}