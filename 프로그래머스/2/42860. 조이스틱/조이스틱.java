class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int n = name.length();
        
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = name.charAt(i) - 'A';
        }
        
        for(int num : numbers) {
            answer += Math.min(num, 26 - num);
        }
        
        int move = n - 1;
        for(int i = 0; i < n; i++) {
            int next = i + 1;
            while(next < n && name.charAt(next) == 'A') next++;
            move = Math.min(move, i + n - next + Math.min(i, n - next));
        }

        answer += move;
        
        return answer;
    }
}