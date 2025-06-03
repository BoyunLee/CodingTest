import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[N][M];

        for(int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        char[][] pattern1 = new char[8][8]; 
        char[][] pattern2 = new char[8][8]; 

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    pattern1[i][j] = 'W';
                    pattern2[i][j] = 'B';
                } else {
                    pattern1[i][j] = 'B';
                    pattern2[i][j] = 'W';
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int changes1 = countMismatch(board, i, j, pattern1);
                int changes2 = countMismatch(board, i, j, pattern2);

                int minCount = Math.min(changes1, changes2);
                
                if (minCount < answer) {
                    answer = minCount;
                }
            }
        }

        System.out.println(answer);
    }

    public static int countMismatch(char[][] board, int start, int end, char[][] pattern) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[start + i][end + j] != pattern[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
