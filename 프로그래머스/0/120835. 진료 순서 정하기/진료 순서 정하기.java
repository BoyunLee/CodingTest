import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] list = emergency.clone();
        Arrays.sort(list);
        for(int i=0; i<emergency.length; i++) {
            for(int j=0; j<list.length; j++) {
                if( emergency[i] == list[j]) {
                    emergency[i] = list.length - j;
                    break;
                }
            }
        } 
        return emergency;
    }
}