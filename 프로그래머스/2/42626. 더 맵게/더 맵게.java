import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // PriorityQueue : 최소힙, 자동으로 원소들을 오름차순으로 정렬
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int score : scoville) {
            heap.add(score);
        }

        // 가장 작은 원소가 K 이상이 될 때까지 반복
        while (heap.size() > 1 && heap.peek() < K) {
            int first = heap.poll();
            int second = heap.poll();
            int newScoville = first + (second * 2);
            heap.add(newScoville);
            answer++;
        }

        // 모든 원소가 K 이상인지 확인
        if (heap.peek() < K) {
            return -1;
        }

        return answer;
    }
}