import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        List<Double> minus = new ArrayList<>();
        
        for(int i=0; i<4; i++) {
            for(int j=i+1; j<4; j++) {
                int x1 = dots[i][0], y1 = dots[i][1];
                int x2 = dots[j][0], y2 = dots[j][1];
                               
                if (x1 == x2) {
                    minus.add(Double.POSITIVE_INFINITY);  // Use infinity for vertical lines
                } else {
                    double mi = (double)(y2 - y1) / (x2 - x1);
                    minus.add(mi);
                }
             }
        }
        
        for (int i = 0; i < minus.size(); i++) {
            for (int j = i + 1; j < minus.size(); j++) {
                if (minus.get(i).equals(minus.get(j))) {
                    return 1; 
                }
            }
        }
        return 0; 
    }
}