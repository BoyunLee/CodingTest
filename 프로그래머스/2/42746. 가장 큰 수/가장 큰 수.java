import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        String[] arr = new String[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        
        if(arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(arr[i]);
        }
        String answer = sb.toString();
        
        return answer;
    }
}