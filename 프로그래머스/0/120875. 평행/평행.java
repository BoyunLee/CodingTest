class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        // 두 점을 골라 기울기를 비교하여 평행 여부를 확인
        for(int i=0; i<4; i++) {
            for(int j=i+1; j<4; j++) {
                for(int k=0; k<4; k++) {
                    if(k != i && k != j) {
                        for(int l=k+1; l<4; l++) {
                            if(l != i && l != j) {
                                // 두 점 (i, j)와 (k, l)의 기울기를 비교
                                int x1 = dots[i][0] - dots[j][0];
                                int y1 = dots[i][1] - dots[j][1];
                                int x2 = dots[k][0] - dots[l][0];
                                int y2 = dots[k][1] - dots[l][1];
                                
                                // 기울기 비교 (분수의 곱셈으로 기울기 비교)
                                if (y1 * x2 == y2 * x1) {
                                    return 1;  // 평행한 경우 1 반환
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
