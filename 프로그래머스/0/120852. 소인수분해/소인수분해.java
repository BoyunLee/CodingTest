import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new TreeSet<>();
        while(n % 2 == 0) {
            set.add(2);
            n = n/2;
        }
        for (int i = 3; i*i <= n; i += 2) {
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            set.add(n);
        }
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}