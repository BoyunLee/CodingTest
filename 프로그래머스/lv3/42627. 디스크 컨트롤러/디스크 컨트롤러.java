import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 작업이 요청되는 시점 기준으로 오름차순 정렬
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        
        // 작업의 소요시간 기준으로 우선 순위 정렬 (짧을 수록 우선순위가 높음)
        Queue<int[]> pq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);
        
        int current = 0;
        int completed = 0;
        int totalResponseTime = 0;
        int jobIndex = 0;
        
        while (completed < jobs.length) {
            // 현재 시간에서 처리할 수 있는 작업들을 우선순위 큐에 추가한다.
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= current) {
                pq.add(jobs[jobIndex]);
                jobIndex++;
            }
            // 우선순위 큐를 이용해서 소요시간이 가장 적은 작업을 선택한다.
			      // 작업의 요청부터 종료까지 걸린 시간을 더해준다.
          	// 현재 시간을 업데이트한다.
            if (!pq.isEmpty()) {
				        int[] job = pq.remove();
                current += job[1];
                totalResponseTime += current - job[0];
                completed++;
            } else {
	            // 현재 시간을 업데이트한다.
                current = jobs[jobIndex][0];
            }
            
        }
		    // 총 대기 시간의 평균을 계산하여 반환 (소수점 이하 버림)
        return totalResponseTime / jobs.length;
    }
}