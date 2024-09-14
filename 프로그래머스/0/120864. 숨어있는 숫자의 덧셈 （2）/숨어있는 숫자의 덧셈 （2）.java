class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String temp = "";
        
        for(int i=0; i<my_string.length(); i++) {
            char c = my_string.charAt(i);
            
            if(Character.isDigit(c)) {
                temp += c;
            } else {
                if(!temp.equals("")) {
                    answer += Integer.parseInt(temp);
                    temp = "";
                }
            }
        }
        
        if(!temp.equals("")) {
            answer += Integer.parseInt(temp);
        }
        
        return answer;
    }
}