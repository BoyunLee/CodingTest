import java.util.*;

class Solution {
    static String[] words = {"A", "E", "I", "O", "U"};
    static List<String> list;
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("");
        int n = list.size();
        for(int i=0; i<n; i++) {
            if(list.get(i).equals(word)) {
                break;
            }
            answer++;
        }
        return answer;
    }
    
    public void dfs(String s){
        list.add(s);
        if(s.length() == 5) return;
        for(int i =0; i<5; i++){
            dfs(s+words[i]);  
        }
        
    }
}