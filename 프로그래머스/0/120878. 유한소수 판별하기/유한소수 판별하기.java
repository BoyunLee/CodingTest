class Solution {
    public int solution(int a, int b) {
        int n = 1;
        for(int i=1; i<=Math.min(a, b); i++) {
            if(a%i == 0 && b%i == 0) {
                n = i;
            }
        }
        
        b /= n;
        
        while(b%2 == 0) {
            b /= 2;
        }
        while(b%5 == 0) {
            b /= 5;
        }
        
        return b == 1 ? 1:2; 
    }
}