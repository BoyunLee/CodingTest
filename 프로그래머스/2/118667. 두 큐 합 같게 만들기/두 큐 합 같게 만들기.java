import java.util.LinkedList;
import java.util.Queue;

class Solution {
        public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long  sum1 = 0;
        long  sum2 = 0;

        for(int i=0; i<queue1.length; i++){
            sum1 += queue1[i];
        }
        for(int i=0; i<queue2.length; i++){
            sum2 += queue2[i];
        }

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int num : queue1) {
            q1.add(num);
        }
        for (int num : queue2) {
            q2.add(num);
        }

        int max = (queue1.length + queue2.length) * 2;

        while (answer < max) {
            if(sum1 == sum2){
                return answer;
            }

            if (sum1 > sum2){
                int num = q1.poll();
                sum1 -= num;
                q2.add(num);
                sum2 += num;
            } else {
                int num = q2.poll();
                sum2 -= num;
                q1.add(num);
                sum1 += num;
            }
            answer++;
        }
        return -1;
    }
}