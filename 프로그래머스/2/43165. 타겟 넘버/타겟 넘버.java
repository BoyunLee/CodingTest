import java.util.*;

class Solution {
    int answer, size;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        size = numbers.length;
        
        dfs(numbers,0,0,target);
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int nowSum, int target) {
        if (depth == size - 1) {
            if (nowSum + numbers[depth] == target)
                answer++;
            if (nowSum - numbers[depth] == target)
                answer++;
            return;
        }
            
        dfs(numbers,depth+1, nowSum + numbers[depth], target);
        dfs(numbers,depth+1, nowSum - numbers[depth], target);
        return;
        
    }
}