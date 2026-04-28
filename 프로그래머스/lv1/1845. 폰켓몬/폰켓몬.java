import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> pocket = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            pocket.add(nums[i]);
        }
        
        answer = Math.min(pocket.size(), nums.length/2);
        return answer;
    }
}