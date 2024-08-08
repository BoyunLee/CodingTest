import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<Integer>[] array = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            array[i] = new ArrayList<>();
        }
            
        for (int[] e : edge) {
            array[e[0]].add(e[1]);
            array[e[1]].add(e[0]);
        }
        
        int[] visited = new int[n+1];
        for (int i=1; i<=n; i++) {
            visited[i] = -1;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = 0;
        int max = 0;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            if(visited[cur] > max) {
                max = visited[cur];
            }
            
            for (int next : array[cur]) {
                if(visited[next] != -1) {
                    continue;
                }
                visited[next] = visited[cur] + 1;
                queue.add(next);
            }
        }
        
        for (int i=0; i<=n; i++) {
            if (visited[i] == max) {
                answer++;
            }
        }
        return answer;
    }
}