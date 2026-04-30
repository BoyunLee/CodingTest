class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++) {
            int cut = schedules[i]+10;
            if(cut%100 >= 60) {
                cut+=40;
            }
            boolean sucess = true;
            
            int day = startday;
            for(int j=0; j<timelogs[i].length; j++) {
                if(day==6 || day==7) {
                    day = (day+1) % 7;
                    if(day == 0) day = 7;
                    continue;
                }
                
                if(timelogs[i][j] > cut) {
                    sucess = false;
                    break;
                }
                
                day = (day+1) % 7;
            }
            if(sucess) answer++;
        }
        return answer;
    }
}