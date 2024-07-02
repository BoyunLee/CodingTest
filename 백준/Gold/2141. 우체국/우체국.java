import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // n개의 숫자 쌍을 저장할 배열 선언
        int[][] pairs = new int[n][2];

        // 데이터 입력받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pairs[i][0] = Integer.parseInt(st.nextToken());
            pairs[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pairs, Comparator.comparingInt(arr -> arr[0]));

        long person = 0;
        for (int i = 0; i < n; i++) {
            person += pairs[i][1];
        }
        person = (person + 1) / 2;

        long sum = 0;
        int answer = 0;
        for(int i=0; i<n; i++){
            sum += pairs[i][1];
            if(sum >= person){
                answer = pairs[i][0];
                break;
            }
        }

        System.out.println(answer);
    }
}