import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        list.add(arr[0]);
        
        for(int i=1; i<arr.length; i++) {
            int n = list.size();
            if(list.get(n-1) != arr[i]) {
                list.add(arr[i]);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int j=0; j<list.size(); j++) {
            answer[j] = list.get(j);
        }

        return answer;
    }
}