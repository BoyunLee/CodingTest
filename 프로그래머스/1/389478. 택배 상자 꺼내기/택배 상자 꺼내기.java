class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int r = (num-1)/w;
        int c = (num-1)%w;
        if(r%2 == 1) {
            c = w-1-c;
        }
        
        int maxr = (n-1)/w;
        int lastCount = n % w == 0 ? w : n % w;

        if(maxr%2 == 1) {
            if(c < w - lastCount) maxr--;
        } else {
            if(c >= lastCount) maxr--;
        }
        
        answer = maxr-r+1;

        return answer;
    }
}