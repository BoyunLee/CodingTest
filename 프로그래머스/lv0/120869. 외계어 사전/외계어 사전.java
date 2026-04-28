class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for(String dicone : dic) {
            int count = 0;
            for(String spellone : spell) {
                if(dicone.contains(spellone)) {
                    count++;
                }
            }
            if(count == spell.length) {
                answer = 1;
                break;
            }
        }
        return answer;
    }
}