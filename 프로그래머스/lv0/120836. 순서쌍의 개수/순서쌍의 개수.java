class Solution {
    public int solution(int n) {
        int answer = 0;
        for(double i=0; i<=n; i++) {
            if(n % i != 0) {
                continue;
            } 
            answer++;
        }
        return answer;
    }
}