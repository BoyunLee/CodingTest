import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        Arrays.sort(sides);

        int min_side = sides[0];
        int max_side = sides[1];
        
        for (int i = max_side - min_side + 1; i <= max_side; i++) {
            answer++;
        }
        
        for (int i = max_side + 1; i < min_side + max_side; i++) {
            answer++;
        }

        return answer;
    }
}