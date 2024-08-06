class Solution {
    public int solution(int n) {
        int answer = 1;
        int pizza = 6;
        while(true) {
            if (answer * 6 % n == 0) {
                break;
            }
            answer++;
        }
        return answer;
    }
}