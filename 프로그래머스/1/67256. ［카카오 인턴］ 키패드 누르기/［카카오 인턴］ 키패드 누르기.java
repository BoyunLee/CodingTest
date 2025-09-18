import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
     
        int[][] keypad = {
            {3,1}, 
            {0,0}, {0,1}, {0,2},
            {1,0}, {1,1}, {1,2},
            {2,0}, {2,1}, {2,2}  
        };
        
        int[] left = {3,0}; 
        int[] right = {3,2};
        
        for(int n : numbers) {
            if(n == 1 || n == 4 || n == 7) {
                answer = answer + "L";
                left = keypad[n];
            } else if(n == 3 || n == 6 || n == 9) {
                answer = answer + "R";
                right = keypad[n];
            } else {
               int[] target = keypad[n];
                
                int leftDist = Math.abs(target[0] - left[0]) + Math.abs(target[1] - left[1]);
                int rightDist = Math.abs(target[0] - right[0]) + Math.abs(target[1] - right[1]);
                
                if(rightDist > leftDist) {
                    answer = answer + "L";
                    left = keypad[n];
                } else if(rightDist < leftDist) {
                    answer = answer + "R";
                    right = keypad[n];
                } else {
                    if(hand.equals("right")) {
                        answer = answer + "R";
                        right = keypad[n];
                    } else if(hand.equals("left"))  {
                        answer = answer + "L";
                        left = keypad[n];
                    }
                }
            }
        }
        return answer;
    }
}