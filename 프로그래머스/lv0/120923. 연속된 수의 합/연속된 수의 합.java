class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        if(num % 2 == 1) {
            int n = total / num;
            int start = n - num/2;
            for(int i=0; i<num; i++) {
                answer[i] = start + i;
            }
        } else {
            int n = total / num;
            int start = n - num/2 + 1;
            for(int i=0; i<num; i++) {
                answer[i] = start + i;
            }
        }
        
        
    
        
        
        return answer;
    }
}