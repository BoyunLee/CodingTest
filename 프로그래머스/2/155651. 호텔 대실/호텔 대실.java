class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        // 1440 = 24*60
        int[] arr = new int[1440];
        
        for (String[] book : book_time) {
            int start = changeMin(book[0]);
            int end = changeMin(book[1])+10;
            
            for (int i = start; i < end && i < 1440; i++) {
                arr[i]++;
            }
        }
        for (int j=0; j<1440; j++) {
            answer = Math.max(answer, arr[j]);
        }
        return answer;
    }
    
    public int changeMin(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        
        return hour*60 + minute;
    }
}