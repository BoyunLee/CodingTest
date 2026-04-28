class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;
        
        for (String key : keyinput) {
            switch (key) {
                case "left":
                    x -= 1;
                    break;
                case "right": // 오타 수정
                    x += 1;
                    break;
                case "up":
                    y += 1;
                    break;
                case "down":
                    y -= 1;
                    break;
            }
            
            x = Math.max(-board[0] / 2, Math.min(board[0] / 2, x));
            y = Math.max(-board[1] / 2, Math.min(board[1] / 2, y));
        }

        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}
