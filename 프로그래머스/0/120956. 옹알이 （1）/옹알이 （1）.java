import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i=0; i<babbling.length; i++) {
            int check = 1;
            for(int j=0; j<babbling[i].length(); j++) {
                if(j+2<babbling[i].length() && babbling[i].substring(j, j+3).equals("aya")) {
                    j+=2;
                }else if(j+1<babbling[i].length() && babbling[i].substring(j, j+2).equals("ye")) {
                    j+=1;
                } else if(j+2<babbling[i].length() && babbling[i].substring(j, j+3).equals("woo")) {
                    j+=2;
                } else if(j+1<babbling[i].length() && babbling[i].substring(j, j+2).equals("ma")) {
                    j+=1;
                } else {
                    check = 0;
                    break;
                }
            }
            if(check == 1) {
                answer++;
            }
        }
        return answer;
    }
}