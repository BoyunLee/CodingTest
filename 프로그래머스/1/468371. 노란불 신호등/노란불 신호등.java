import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        
        int maxTime = 1;
        for (int[] s : signals) {
            int cycle = s[0] + s[1] + s[2];
            maxTime = lcm(maxTime, cycle);
        }
        
        for(int i=1; i<=maxTime; i++) {
            boolean allYellow = true;
            
            for(int j=0; j<n; j++) {
                int green = signals[j][0];
                int yellow = signals[j][1];
                int red = signals[j][2];

                int cycle = green + yellow + red;
                int mod = (i - 1) % cycle;
                
                if(!(mod >= green && mod < green + yellow)) {
                    allYellow = false;
                    break;
                }
            }
            if(allYellow) return i;
        }
        return -1;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    
    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}