import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] d = new int[n + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            // 초기화: 각 원소 자체가 하나로 이루어진 수열이 가장 긴 증가하는 수열일 수 있음
            d[i] = a[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (a[j] < a[i]) {
                    // 부분 수열의 합이 최대가 되도록 업데이트
                    d[i] = Math.max(d[i], d[j] + a[i]);
                }
            }
            // 최대값 업데이트
            max = Math.max(max, d[i]);
        }

        System.out.println(max);

        sc.close();
    }
}
