import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int min = 100;
        int index = 0;
        int[] memo = new int[array.length]; 
        for(int i=0; i<array.length; i++) {
            memo[i] = Math.abs(array[i] - n);
            if(memo[i] < min) {
                min = memo[i];
                index = i;
            } 
            if(memo[i] == min) {
                index = array[i] < array[index] ? i : index;
            }
        }
        
        answer = array[index];
        
        return answer;
    }
}