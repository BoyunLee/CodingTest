class Solution {
    public long solution(int k, int d) {
        
        long answer = 0;
        long sum = 0;
        
        for(int a=0; a<=d; a+=k){
            for(int b=0; b<=d; b+=k){
                sum = (long)Math.sqrt(a*a*k*k + b*b*k*k);
                if(sum <= d){
                    answer++;
                }
            }
        }
        return answer;
    }
} 