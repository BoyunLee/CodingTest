import java.util.ArrayList;
import java.util.List;

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
        
        // 각 기능이 완료되는 날짜를 계산하여 days 배열에 저장
        int n = progresses.length;
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {

            // 100 <= progresses + speeds x day
            // - speeds x day <= -100 + progresses
            // day >= (100 - progresses) / speeds
            // Math.ceil : 무조건 올림 처리
            days[i] = (int) Math.ceil ((100.0 - progresses[i]) / speeds[i]);
            }

        List<Integer> answerList = new ArrayList<>();
        int count = 1;
        int countDay = days[0];

        for (int i = 1; i < n; i++) {
            if (days[i] <= countDay) {
                count++;
            } else {
                answerList.add(count);
                count = 1;
                countDay = days[i];
            }
        }

        // 마지막 배포된 기능의 개수를 추가
        answerList.add(count);

        // 리스트를 배열로 변환하여 반환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
        }
    }
