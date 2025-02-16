import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String m = sc.nextLine();

        int[] arr = new int[n];
        String[] numbers = m.split("");

        int answer = 0;

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        for(int a : arr) {
            answer += a;
        }

        System.out.println(answer);
    }
}
