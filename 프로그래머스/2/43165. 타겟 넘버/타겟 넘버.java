class Solution {
    static int n;
    static int answer;
    static int t;
    static int[] nums;
        
    public int solution(int[] numbers, int target) {
        answer = 0;
        n = numbers.length;
        t = target;
        nums = numbers;
        
        dfs(0, 0);
        
        return answer;
    }
    
    static void dfs(int idx, int total) {
        if(idx == n) {
            if(total == t) {
                answer++;
            }
            return;
        }
        
        dfs(idx+1, total+nums[idx]);
        dfs(idx+1, total-nums[idx]);
    }
}