import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        // n개의 숫자 쌍을 저장할 배열 선언
        int[][] days = new int[N][2];

        // 데이터 입력받기
        for (int i = 0; i < N; i++) {
            days[i][0] = sc.nextInt();
            days[i][1] = sc.nextInt();
            sc.nextLine();
        }

        int[] dp = new int[N+1];

        for (int i = 0; i < N; i++) {
            int time = days[i][0] + i;
            if (time <= N) {
                dp[time] = Math.max(dp[time], dp[i] + days[i][1]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        int answer = 0;
        for (int i = 0; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
