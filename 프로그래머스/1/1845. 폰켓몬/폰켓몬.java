import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length;
        
        Arrays.sort(nums);
        int count =0;
        
        for(int i=0; i<N-1; i++){
            if(nums[i] != nums[i+1]){
                count++;
                if(count >= N/2){
                    break;
                }
            }
        }
        answer = Math.min(count + 1, N / 2);
        return answer;
    }
}