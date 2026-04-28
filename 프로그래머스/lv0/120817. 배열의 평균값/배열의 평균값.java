class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double sum = 0;
        int n = numbers.length;
        for(int i=0; i<n; i++) {
            sum += numbers[i];
        }
        answer = sum / n;
        return answer;
    }
}