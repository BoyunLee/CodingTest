import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < phone_book.length; i++) {
                map.put(phone_book[i], i);
        }
        
        for (int i = 0; i < phone_book.length; i++){
            for (int j = 0; j < phone_book[i].length(); j++){
               String prefix = phone_book[i].substring(0, j + 1);
                if (map.containsKey(prefix) && map.get(prefix) != i) {
                    return false; 
                }
            }
        }  
        return answer;
    }
}