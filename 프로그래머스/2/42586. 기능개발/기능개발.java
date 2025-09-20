import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int n = progresses.length;
        int[] done = new int[n];
        
        for(int i=0; i<n; i++) {
            int count=0;
            while(progresses[i] < 100) {
                progresses[i] += speeds[i];
                count++;
            }
            done[i] = count;
        }
        
        List<Integer> list = new ArrayList<>();
        
        int current = done[0];
        int donecount = 1;
        
        for(int k=1; k<n; k++) {
            if(current >= done[k]) {
                donecount++;
            } else {
                list.add(donecount);
                donecount = 1;
                current = done[k];
            }
        }
        list.add(donecount);
        
        int m = list.size();
        answer = new int[m];
        
        for(int j=0; j<m; j++) {
            answer[j] = list.get(j);
        }
        
        
        return answer;
    }
}