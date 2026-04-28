class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int cupon1 = 0;
        int cupon2 = 0;
        
        while(chicken > 9) {
            cupon1 = chicken / 10;
            cupon2 = chicken % 10;
            chicken = cupon1 + cupon2;
            answer += cupon1;
        }
        return answer;
    }
}