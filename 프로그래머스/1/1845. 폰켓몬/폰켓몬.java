import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        Set<Integer> set = new HashSet<>(); 
        for (int num : nums) {
                set.add(num);
        }

        int N = nums.length;
        int S = set.size();

        answer = Math.min(S, N / 2);

        return answer;
    }
}