class Solution {
    // 최대 공약수(GCD)를 구하는 메소드
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // 두 분수의 합을 계산
        int up = numer1 * denom2 + numer2 * denom1;
        int down = denom1 * denom2;
        
        // 최대 공약수를 구해 약분하기
        int gcdValue = gcd(up, down);
        int simplifiedNumerator = up / gcdValue;
        int simplifiedDenominator = down / gcdValue;

        // 결과 반환
        int[] answer = {simplifiedNumerator, simplifiedDenominator};
        return answer;
    }
}