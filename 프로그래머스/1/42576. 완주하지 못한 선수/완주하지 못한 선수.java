import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        // participant 배열 순회
        for (int i = 0; i < participant.length; i++) {
            String player = participant[i];
            if (map.containsKey(player)) {
                map.put(player, map.get(player) + 1);
            } else {
                map.put(player, 1);
            }
        }

        // completion 배열 순회
        for (int i = 0; i < completion.length; i++) {
            String player = completion[i];
            if (map.containsKey(player)) {
                map.put(player, map.get(player) - 1);
            }
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}