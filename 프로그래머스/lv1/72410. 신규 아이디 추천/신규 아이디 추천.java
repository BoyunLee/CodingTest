class Solution {
    public String solution(String new_id) {
        
        String one = new_id.toLowerCase();
        
        String two = one.replaceAll("[^a-z0-9-_.]", "");
        
        String three = two.replaceAll("[.]{2,}", ".");
        
        String four = three.replaceAll("^\\.|\\.$", "");
        
        String answer = four;
        
        if(answer.length() == 0) {
            answer = "a";
        }
        
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("\\.$", "");
        }
        
        if(answer.length() <= 2) {
            while(answer.length() < 3) {
                answer = answer + answer.charAt(answer.length() - 1);
            }
        }
        
        return answer;
    }
}