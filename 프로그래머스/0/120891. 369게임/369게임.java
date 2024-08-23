class Solution {
    public int solution(int order) {
        int answer = 0;

        while (order > 0) {
            int digit = order % 10; 
            if(digit == 0) {
                order = order / 10; 
                continue;
            }
            if(digit % 3 == 0) {
                answer++;
            }
            order = order / 10; 
        }
        return answer;
    }
}