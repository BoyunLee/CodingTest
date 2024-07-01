import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // n개의 숫자 쌍을 저장할 배열 선언
        int[][] meetings = new int[n][2];

        // 데이터 입력받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        // 끝나는 시간을 기준으로 오름차순 정렬
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int result = 0;
        int lastEndTime = 0;

        // 최대 회의 수 계산 (Greedy Algorithm)
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= lastEndTime) {
                result++;
                lastEndTime = meetings[i][1];
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
