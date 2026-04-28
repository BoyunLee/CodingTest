import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> list;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        list = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(list);
        answer = list.get(0).split(" ");

        return answer;
    }
    public void dfs(String start, String route, String[][] tickets, int depth) {
        if(depth == tickets.length) {
            list.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, depth+1);
                visited[i] = false;
            }
        }
    }
}