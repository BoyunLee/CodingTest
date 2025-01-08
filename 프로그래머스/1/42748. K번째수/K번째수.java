import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        for(int m=0; m<n; m++) {
            int i = commands[m][0] - 1;
            int j = commands[m][1] - 1;
            int k = commands[m][2] - 1;
            
            int[] newarray = Arrays.copyOfRange(array, i, j+1);
            Arrays.sort(newarray);
            
            answer[m] = newarray[k];
        }
        return answer;
    }
}