class Solution {
    public int solution(int balls, int share) {
        long answer = 1;
        int shareIndex = 1;
        for(int i = share+1; i <= balls; i++){
            answer *= i;
            answer /= shareIndex;
            shareIndex++;
        }
        
        return (int)answer;
    }
}