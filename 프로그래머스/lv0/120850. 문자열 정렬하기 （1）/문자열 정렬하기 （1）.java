import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        String numbers = my_string.replaceAll("[^0-9]", "");
        int[] answer = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            answer[i] = Character.getNumericValue(numbers.charAt(i));
        }
        Arrays.sort(answer);
        return answer;
    }
}