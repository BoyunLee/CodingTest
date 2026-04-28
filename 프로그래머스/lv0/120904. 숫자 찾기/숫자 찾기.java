public class Solution {
    public int solution(int num, int k) {
        // num을 문자열로 변환
        String numStr = Integer.toString(num);
        
        // k를 문자열로 변환
        String kStr = Integer.toString(k);
        
        // numStr에서 kStr의 위치를 찾음
        int index = numStr.indexOf(kStr);
        
        // indexOf는 0부터 시작하므로 +1
        // k가 존재하지 않으면 -1 반환
        return index != -1 ? index + 1 : -1;
    }
}
