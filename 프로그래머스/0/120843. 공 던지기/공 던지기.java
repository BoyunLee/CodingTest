class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int n = numbers.length;
        int index = (k - 1) * 2 % n;
        answer = numbers[index];
        return answer;
    }
}