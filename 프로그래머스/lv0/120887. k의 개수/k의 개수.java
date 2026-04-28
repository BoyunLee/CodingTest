class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int n=i; n<=j; n++) {
            int m = n;
            while(m > 0) {
                if(m % 10 == k) {
                    answer++;
                } 
                m = m / 10;
            }
        }
        return answer;
    }
}