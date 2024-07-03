import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {
        int answer = -1;

        int[] dp1 = new int[topping.length];
        Set<Integer> start = new HashSet<Integer>();
        for(int i=0; i<topping.length; i++){
            start.add(topping[i]);
            dp1[i] = start.size();
        }

        int[] dp2 = new int[topping.length];
        Set<Integer> end = new HashSet<Integer>();
        for(int j=topping.length-1; j>=0; j--){
            end.add(topping[j]);
            dp2[j] = end.size();
        }

        int count=0;
        for(int i=0; i<topping.length-1; i++){
            if(dp1[i] == dp2[i+1]){
                count++;
            }
        }

        answer = count;
        return answer;
    }
}