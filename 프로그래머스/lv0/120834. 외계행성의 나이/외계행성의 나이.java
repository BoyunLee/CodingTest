class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        
        while (age>0) {
            int k = age % 10;
            char c = (char)(k + 'a');
            sb.insert(0, c);
            
            age/=10;
        }
        return sb.toString();
    }
}