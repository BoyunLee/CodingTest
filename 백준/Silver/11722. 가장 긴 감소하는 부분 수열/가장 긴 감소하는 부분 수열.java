import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[] S = new int[N];
        Arrays.fill(S, 1);

        for (int i=1; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (A[j] > A[i]) {
                    S[i] = Math.max(S[i], S[j] + 1);
                }
            }
        }

        int result = Arrays.stream(S).max().orElse(0);

        // 최대값 출력
        System.out.println(result);

        sc.close();
        
    }
}
