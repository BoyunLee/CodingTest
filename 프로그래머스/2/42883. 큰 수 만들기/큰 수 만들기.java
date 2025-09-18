import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(char c : number.toCharArray()){
            while(sb.length() > 0 && count < k && sb.charAt(sb.length() - 1) < c){
                sb.deleteCharAt(sb.length() - 1);
                count++;
            }
            sb.append(c);
        }

        sb.setLength(sb.length() - (k - count));

        return sb.toString();
    }
}
