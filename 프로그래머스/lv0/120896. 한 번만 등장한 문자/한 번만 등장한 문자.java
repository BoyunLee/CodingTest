import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            int count = 0;
            for(int j=0; j<s.length(); j++) {
                if(i == j) {
                    continue;
                }
                
                if(s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }
            if(count < 1) {
                answer.append(s.charAt(i));
            }
        }
        
        // 정렬 과정 추가
        char[] answerArray = answer.toString().toCharArray();
        Arrays.sort(answerArray);

        return new String(answerArray);
    }
}