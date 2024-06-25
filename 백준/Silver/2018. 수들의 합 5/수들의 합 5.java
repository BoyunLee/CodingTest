import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while (end_index != N) {
            // sum이 N과 같다면, count를 증가시키고 end_index를 증가시키며 sum을 갱신합니다.
            if ( sum == N ) {
                count++;
                end_index++;
                sum = sum + end_index;
            // sum이 N보다 크다면, start_index를 증가시키고 sum에서 start_index에 해당하는 값을 뺍니다.
            } else if ( sum > N ) {
                sum = sum - start_index;
                start_index++;
            // sum이 N보다 작다면, end_index를 증가시키고 sum에 end_index에 해당하는 값을 더합니다.
            } else {
                end_index++;
                sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}