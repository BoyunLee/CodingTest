public class Solution {
    public int solution(int n) {
        boolean[][] board = new boolean[n][n];
       
        return queen(board, 0, n); 
    }
    
    int queen(boolean[][] board, int row, int n) {
        if (row == n) return 1;
        
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (checkBoard(board, row, col, n)) {
                board[row][col] = true;
                count += queen(board, row + 1, n);
                board[row][col] = false;
            }
        }
        return count;
    }
    
    boolean checkBoard(boolean[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }
        
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }
        
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j]) return false; 
        }
        
        return true;
    }
}