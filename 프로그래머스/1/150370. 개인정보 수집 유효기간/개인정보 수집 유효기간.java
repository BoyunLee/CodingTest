import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        
        String[][] type = new String[terms.length][2];
        for(int i=0; i<terms.length; i++) {
            type[i] = terms[i].split(" ");
        }
        
        String[] todays = today.split("\\.");
        int todayYear = Integer.parseInt(todays[0]);
        int todayMonth = Integer.parseInt(todays[1]);
        int todayDay = Integer.parseInt(todays[2]);
        int todayTotal = todayYear * 12 * 28 + todayMonth * 28 + todayDay;
        
        for(int i=0; i<privacies.length; i++) {
            String[] array = privacies[i].split(" ");
            
            String date = array[0];
            int num = 0;
            for(int j=0; j<terms.length; j++) {
                if(type[j][0].equals(array[1])) {
                    num = Integer.parseInt(type[j][1]);
                }
            }
            
            String[] temp = date.split("\\.");
            int tempYear = Integer.parseInt(temp[0]);
            int tempMonth = Integer.parseInt(temp[1]);
            int tempDay = Integer.parseInt(temp[2]);
            int tempTotal = tempYear * 12 * 28 + tempMonth * 28 + tempDay;
            int expireTotal = tempTotal + num * 28;
            
            if(expireTotal <= todayTotal) {
                list.add(i+1);
            }
  
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    
}