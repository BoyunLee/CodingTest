import java.util.*;

class Solution {
    
    int n, answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        n = numbers.length;
        
        dfs(0, 0, numbers, target);
            
        return answer;
    }
    
    public void dfs(int index, int sum, int[] numbers, int target) {
        if(index == n) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        
        dfs(index+1, sum+numbers[index], numbers, target);
        dfs(index+1, sum-numbers[index], numbers, target);
    }
    
}