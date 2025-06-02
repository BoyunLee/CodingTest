import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        List<String> results = new ArrayList<>();

        int index = 0;

        for(int i = 1; i <= n; i++) {
            stack.push(i);
            results.add("+");

            while (!stack.isEmpty() && stack.peek() == arr[index]) {
                stack.pop();
                results.add("-");
                index++;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            for (String result : results) {
                System.out.println(result);
            }
        }
    }
}
