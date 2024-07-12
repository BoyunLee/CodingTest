import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        int N = numbers.length();
        int[] arr = new int[N];
        boolean[] visit = new boolean[N];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(numbers.charAt(i) + "");
        }

        for (int i = 1; i <= N; i++) {
            backtrack(arr, i, visit, "", 0, set);
        }

        answer = set.size();
        return answer;
    }

    public void backtrack(int[] nums, int k, boolean[] visit, String x, int depth, Set<Integer> set) {
        if (x.length() == k) {
            if (isPrime(Integer.parseInt(x))) {
                set.add(Integer.parseInt(x));
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                backtrack(nums, k, visit, x + nums[i], depth + 1, set);
                visit[i] = false;
            }
        }
    }

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
