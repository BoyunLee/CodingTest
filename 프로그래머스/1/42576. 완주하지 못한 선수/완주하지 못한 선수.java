
import java.util.HashMap;
    
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        // participant 배열 순회
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // completion 배열 순회
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        // 해시맵에서 값이 0이 아닌 참가자 찾기
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
        return answer;
    }
}