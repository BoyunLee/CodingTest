import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        List<Integer> sums = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<i; j++){
                for(int k=0; k<j; k++){
                    sums.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        for(int sum : sums){
            int count=0;
            for(int n=1; n<=sum; n++){
                if (sum%n == 0){
                    count++;
                }
            }
            if(count == 2){
                answer++;
            }
        }
        return answer;
    }
}
