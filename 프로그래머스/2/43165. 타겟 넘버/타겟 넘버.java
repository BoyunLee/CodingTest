import java.util.*;

class Solution {
    int size, answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        size = numbers.length;
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == size-1) {
            if (sum + numbers[depth] == target) {
                answer++;
            }
            if(sum - numbers[depth] == target) {
                answer++;
            }
            return;
        }
        
        dfs(numbers, target, depth+1, sum+numbers[depth]);
        dfs(numbers, target, depth+1, sum-numbers[depth]);
    }
}