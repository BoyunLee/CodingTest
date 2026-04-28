class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i=1; i<food.length; i++) {
            int n = food[i] / 2;
            for(int j=0; j<n; j++) {
                answer += Integer.toString(i);
            }
        }
        
        answer += '0';
        
        String reversed = new StringBuilder(answer.substring(0, answer.length() - 1))
                          .reverse().toString();
        answer += reversed;
        
        return answer;
    }
}