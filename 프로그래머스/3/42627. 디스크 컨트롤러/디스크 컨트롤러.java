import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        
        Queue<int[]> pq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);
        
        int current = 0;
        int completed = 0;
        int totalTime = 0;
        int jobIndex = 0;
        
        while (completed < jobs.length) {
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= current) {
                pq.add(jobs[jobIndex]);
                jobIndex++;
            }
            if (!pq.isEmpty()) {
                int[] job = pq.remove();
                current += job[1];
                totalTime += current - job[0];
                completed++;
            } else {
                current = jobs[jobIndex][0];
            }
        } 
        return totalTime / jobs.length;
    }
}