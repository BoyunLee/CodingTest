import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        // 결과를 담을 리스트
        List<Integer> answerList = new ArrayList<>();

        // 첫 번째 원소 추가
        answerList.add(arr[0]);
        
        // 중복 제거하면서 리스트에 추가
        for (int i = 1; i < arr.length; i++) {
            // 현재 결과 리스트의 마지막 원소와 현재 원소가 다른 경우에만 추가
            if (answerList.get(answerList.size() - 1) != arr[i]) {
                answerList.add(arr[i]);
            }
        }
        
        // 리스트를 배열로 변환하여 반환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}