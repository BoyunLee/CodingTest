class Solution {
    public int solution(int n) {
        int answer = 1;
        int pizza = 7;
        while(true) {
            if (n <= pizza) {
                break;
            } else {
                answer++;
                pizza += 7;
            }
        }
        return answer;
    }
}