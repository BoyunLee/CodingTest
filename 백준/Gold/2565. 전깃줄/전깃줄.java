import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리

        // n개의 숫자 쌍을 저장할 배열 선언
        int[][] pairs = new int[n][2];

        // 데이터 입력받기
        for (int i = 0; i < n; i++) {
            pairs[i][0] = sc.nextInt();
            pairs[i][1] = sc.nextInt();
            sc.nextLine(); // 개행 문자 처리
        }

        // 첫 번째 숫자를 기준으로 오름차순 정렬
        Arrays.sort(pairs, Comparator.comparingInt(arr -> arr[0]));

        int[] dp = new int[n];

        for (int i=0; i<n; i++) {
            dp[i] = 1;
            for (int j = 0; j<i; j++){
                if (pairs[i][1] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = n - Arrays.stream(dp).max().getAsInt();
        System.out.println(result + "\n");

        sc.close();
    }
}