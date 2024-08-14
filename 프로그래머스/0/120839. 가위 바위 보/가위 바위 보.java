
class Solution {
    public String solution(String rsp) {
        StringBuilder answer = new StringBuilder();
        char[] rsplist = rsp.toCharArray();
        for(char i : rsplist) {
            if(i == '2') {
                answer.append('0');
            } else if(i == '0') {
                answer.append('5');
            } else if(i == '5') {
                answer.append('2');
            }
        }
        return answer.toString();
    }
}