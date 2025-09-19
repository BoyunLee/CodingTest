class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        String[] slist = s.split("");
        
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(slist[i].equals("(")) {
                count += 1;
            } else if(slist[i].equals(")")) {
                count -= 1;
            }
            
            if(count < 0) {
                return false;
            }
        }
        
        if(count != 0) {
            return false;
        }

        return answer;
    }
}