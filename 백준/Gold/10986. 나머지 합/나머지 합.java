import java.io.IOException;
import java.util.Scanner;

public class Main {

    // 주어진 수열에서 부분 수열의 합이 M으로 나누어떨어지는 경우의 수를 구하는 문제입니다. 
    public static void main(String[] args) throws IOException{

        /* 기존 책의 코드 Scanner sc = new Scanner(System.in) 만 사용할 경우 
            Resource leak: 'sc' is never closed 오류 발생
            코드 돌아가는데 큰 문제는 없음 하지만 만약 close() 메소드를 명시적으로 호출하는 것을 잊어버린다면, 
            해당 자원이 해제되지 않고 남아 있을 수 있고 이는 메모리 누수 등의 문제를 발생시킬 수 있음
            try (Scanner sc = new Scanner(System.in)) 구문을 사용하여 Scanner 객체를 자동으로 닫도록 수정
        */
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            long[] S = new long[N];
            long[] C = new long[M];
            long answer = 0;

            S[0] = sc.nextInt();

            for (int i = 1; i < N; i++) {
                S[i] = S[i-1] + sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                int remainder = (int)(S[i] % M);
                if (remainder == 0) answer++;
                C[remainder]++;
            }

            for (int i = 0; i < M; i++) {
                if (C[i] > 1) {
                    answer = answer + (C[i] * (C[i]-1) / 2);
                }
            }
            System.out.println(answer);
            };
    }
}
