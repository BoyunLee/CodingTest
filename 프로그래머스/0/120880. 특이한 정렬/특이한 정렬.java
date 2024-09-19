import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        // 숫자와 차이값을 저장할 배열 생성
        int length = numlist.length;
        int[][] minus = new int[length][2];
        
        // 차이값과 원래 인덱스를 저장
        for (int i = 0; i < length; i++) {
            minus[i][0] = numlist[i]; // 원래 숫자
            minus[i][1] = Math.abs(numlist[i] - n); // n과의 차이
        }
        
        // 차이값을 기준으로 정렬
        Arrays.sort(minus, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        
        // 정렬된 숫자만 추출하여 결과 배열에 저장
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = minus[i][0];
        }
        
        return answer;
    }
}
