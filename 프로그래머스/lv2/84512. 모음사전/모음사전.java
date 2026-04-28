import java.util.*;

class Solution {
    static String[] words = {"A", "E", "I", "O", "U"};
    int answer = 0;
    int count = 0;
 
    public int solution(String word){
        dfs("", word);
        
        return answer;
    }
    
    public void dfs(String s, String word){
        if(s.equals(word)) {
           answer = count;
        }
        
        count++;
        
        if(s.length() == 5) return;
        
        for(int i =0; i<5; i++){
            dfs(s+words[i], word);  
        }
    }
}