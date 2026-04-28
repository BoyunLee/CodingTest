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
            
            // i까지 갔다가 돌아가서 끝 처리
            move = Math.min(move, i * 2 + (n - next));

            // 뒤쪽부터 처리하다가 돌아오기
            move = Math.min(move, (n - next) * 2 + i);
        }

        answer += move;
        
        return answer;
    }
}