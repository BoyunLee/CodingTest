class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 1;
        for(int i=1; i<12; i++) {
            sum *= i;
            if(sum > n) {
                answer = i-1;
                break;
            }
        }
        return answer;
    }
}