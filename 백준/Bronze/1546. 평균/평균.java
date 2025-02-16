import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int h = arr[n-1];

        double sum = 0;
        double answer = 0;

        for(int i=0; i<n; i++) {
            sum += arr[i];
        }

        answer = sum * 100 / (h * n);

        System.out.println(answer);
    }
}
