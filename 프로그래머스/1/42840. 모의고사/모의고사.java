import java.util.*;

class Solution {
    public int[] solution(int[] answers) {    
        ArrayList<Integer> list = new ArrayList<>();
        
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3];
        
        int one = 0;
        int two = 0;
        int three = 0;
        
        for(int i=0; i<answers.length; i++) {
            if (answers[i] == a[i % 5]) {
                one++;
            }
            score[0] = one;
        }
        
        for(int i=0; i<answers.length; i++) {
            if (answers[i] == b[i % 8]) {
                two++;
            }
            score[1] = two;
        }
        
        for(int i=0; i<answers.length; i++) {
            if (answers[i] == c[i % 10]) {
                three++;
            }
            score[2] = three;
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        for(int i=0; i<3; i++) {
            if (score[i] == max) {
                list.add(i + 1);
            }
        }    
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}