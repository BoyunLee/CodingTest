import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int p = progresses.length;
        int[] done = new int[p];
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<p; i++) {
            int n = 0;
            while(progresses[i] < 100) {
                progresses[i] += speeds[i];
                n++;
            }
            done[i] = n;
        }
        
        int count = 1;
        int temp = done[0];
        
        for(int j=1; j<p; j++) {
            if(done[j] <= temp) {
                count++;
            } else {
                list.add(count);
                count = 1;
                temp = done[j];
            }
        }
        
        list.add(count);
        
        int[] answer = new int[list.size()];
        for(int k=0; k<list.size(); k++) {
            answer[k] = list.get(k);
        }
        
        return answer;
    }
}