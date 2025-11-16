import java.util.*;

class Solution {
    int answer;
    boolean visited[];
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int index, int n, int[][] computers) {
        visited[index] = true;
        
        for(int j=0; j<n; j++) {
            if(computers[index][j] == 1 && !visited[j]) {
                dfs(j, n, computers);
            }
        }
    }
}