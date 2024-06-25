import java.io.BufferedReader; // 문자 입력 스트림에서 텍스트를 읽을 때 버퍼링을 제공. 효율적으로 읽기 위해 사용.
import java.io.InputStreamReader; // 바이트 스트림을 문자 스트림으로 변환.
import java.util.StringTokenizer; // 문자열을 구분자(delimiter)를 기준으로 분리.

public class Main {

    // 입력 처리 및 초기화
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2차원 배열 A 초기화
        int A[][] = new int[N +1][N +1];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++)  {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구간 합 배열 D 계산
        // D[i][j]는 (1,1)에서 (i,j)까지의 합을 저장
        int D[][] = new int[N+1][N+1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {

                // 구간 합 구하기
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
            }
        }

        // 구간 합 계산 및 출력
        // ex) 2 2 3 4 
        // A[3][4] - A[2][2]
        // D[3][4] - D[1][4] - D[3][1] + D[1][1]
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            System.out.println(result);

        }

     }
}
