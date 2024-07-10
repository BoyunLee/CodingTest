import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(bottomUp(n));
    }

    static String bottomUp(int num) {
        int[] dp = new int[num + 1];
        int[] list = new int[num + 1];

        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + 1;
            list[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                list[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                list[i] = i / 3;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(dp[num]).append("\n");

        ArrayList<Integer> path = new ArrayList<>();
        for (int i = num; i != 0; i = list[i]) {
            path.add(i);
        }

        for (int i : path) {
            result.append(i).append(" ");
        }

        return result.toString();
    }
}

