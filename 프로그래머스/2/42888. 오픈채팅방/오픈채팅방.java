import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> nameMap = new HashMap<>();
        List<String[]> logs = new ArrayList<>();
        
        for(String one : record) {
            String[] parts = one.split(" ");
            String command = parts[0];
            String uid = parts[1];
            
            if(command.equals("Enter") || command.equals("Change")) {
                String nickname = parts[2];
                nameMap.put(uid, nickname);
            }
            
            if(!command.equals("Change")) {
                logs.add(new String[]{command, uid});
            }
        }
        
        String[] answer = new String[logs.size()];
        int i=0;
        
        for(String[] log : logs) {
            String command = log[0];
            String uid = log[1];
            String nickname = nameMap.get(uid);
            
            if(command.equals("Enter")) {
                answer[i++] = nickname + "님이 들어왔습니다.";
            } else {
                answer[i++] = nickname + "님이 나갔습니다."; 
            }
        }
        return answer;
    }
}