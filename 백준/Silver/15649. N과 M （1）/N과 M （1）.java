import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.close();

        // 결과를 담을 배열과 사용 여부를 체크할 배열
        int[] result = new int[M];
        boolean[] used = new boolean[N + 1];

        // 백트래킹 함수 호출
        backtrack(N, M, 0, result, used);
    }

    public static void backtrack(int N, int M, int depth, int[] result, boolean[] used) {
        // 기저 사례: M개의 숫자를 모두 뽑았다면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        // 1부터 N까지 숫자 사용
        for (int i = 1; i <= N; i++) {
            // i가 아직 사용되지 않았다면
            if (!used[i]) {  
                used[i] = true;
                result[depth] = i;
                // 다음 깊이로 이동
                backtrack(N, M, depth + 1, result, used);
                // 백트래킹을 위해 사용 표시를 되돌림
                used[i] = false;
            }
        }
    }
}
