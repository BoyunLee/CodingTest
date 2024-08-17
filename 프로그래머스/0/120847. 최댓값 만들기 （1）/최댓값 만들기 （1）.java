import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int n = numbers.length;
        Arrays.sort(numbers);
        answer = numbers[n-1]*numbers[n-2];
        return answer;
    }
}