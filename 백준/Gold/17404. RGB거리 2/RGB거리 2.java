import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        // n개의 숫자 쌍을 저장할 배열 선언
        int[][] colors = new int[N][3];

        // 데이터 입력받기
        for (int i = 0; i < N; i++) {
            colors[i][0] = sc.nextInt();
            colors[i][1] = sc.nextInt();
            colors[i][2] = sc.nextInt();
            sc.nextLine();
        }

        int result = Integer.MAX_VALUE;

        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[N][3];

            // 첫 번째 집의 색을 고정하고 나머지 색의 비용을 매우 큰 값으로 설정
            for (int i = 0; i < 3; i++) {
                if (i == firstColor) {
                    dp[0][i] = colors[0][i];
                } else {
                    dp[0][i] = 1001; // 1000보다 큰 값으로 초기화하여 선택되지 않게 함
                }
            }

            // dp 배열 채우기
            for (int i = 1; i < N; i++) {
                dp[i][0] = colors[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = colors[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = colors[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
            }

            // 마지막 집을 선택할 때 첫 번째 집과 색이 같은 경우를 고려하지 않도록 함
            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor != firstColor) {
                    result = Math.min(result, dp[N-1][lastColor]);
                }
            }
        }

        // 결과 출력
        System.out.println(result);

        sc.close();
    }
}
