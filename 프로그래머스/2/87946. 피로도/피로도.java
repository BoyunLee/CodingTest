import java.util.*;

class Solution {
    // 클래스 변수로 선언하여 접근 가능
    private int answer = 0; 

    public int solution(int k, int[][] dungeons) {
        int N = dungeons.length;
        boolean[] visited = new boolean[N];
        
        backtrack(k, N, visited, dungeons, 0);
        return answer;
    }
    
    // backtrack
    private void backtrack(int curr_k, int N, boolean[] visited, int[][] dungeons, int cnt) { 
        // base case
        if (cnt > answer) {
            answer = cnt;
        }
        
        // recursive call
        for(int i = 0; i < N; i++) {
            if(curr_k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                backtrack(curr_k - dungeons[i][1], N, visited, dungeons, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
