import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i+=k) {
            long d2 = (long)Math.pow(d,2);
            long i2 = (long)Math.pow(i,2);
            int a = (int)Math.sqrt(d2-i2);
            answer += (a/k) + 1;
        }
        return answer;
    }
}