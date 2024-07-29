class Solution {
    public int solution(String s) {
        int answer = 0;

        String[] list = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i<list.length; i++) {
            if(s.contains(list[i])) {
        		s = s.replace(list[i], Integer.toString(i));
        	}  
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}