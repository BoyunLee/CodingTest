import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        list.add(arr[0]);
        int n = list.size();
        for(int i=1; i<arr.length; i++) {
            if(list.get(n-1) != arr[i]) {
                list.add(arr[i]);
                n = list.size();
            }
        }
        answer = new int[n];
        for(int i=0; i<n; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}