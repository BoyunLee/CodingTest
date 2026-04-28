class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String number = String.valueOf(a) + String.valueOf(b);
        answer = Math.max(Integer.parseInt(number), 2*a*b);
        return answer;
    }
}