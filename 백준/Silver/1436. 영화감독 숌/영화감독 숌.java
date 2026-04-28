import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count = 1;

        int num = 666;

        while (count < N) {
            num++;
            
            if (String.valueOf(num).contains("666")) {
                count++;
            }
            
            if (count == N) break;
        }

        System.out.println(num);

    }
}