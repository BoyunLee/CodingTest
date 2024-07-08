import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리

        // n개의 숫자 쌍을 저장할 배열 선언
        int[][] colors = new int[N][3];

        // 데이터 입력받기
        for (int i = 0; i < N; i++) {
            colors[i][0] = sc.nextInt();
            colors[i][1] = sc.nextInt();
            colors[i][2] = sc.nextInt();
            sc.nextLine(); // 개행 문자 처리
        }

        int[][] dp = new int[N][3];
        
        // 초기값 설정
        dp[0][0] = colors[0][0];
        dp[0][1] = colors[0][1];
        dp[0][2] = colors[0][2];
        

        // dp 배열 채우기
        for (int i = 1; i < N; i++) {
            dp[i][0] = colors[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = colors[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = colors[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        // 최솟값 찾기
        int result = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));

        // 결과 출력
        System.out.println(result);

        sc.close();
    }
}
