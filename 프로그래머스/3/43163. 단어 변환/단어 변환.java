import java.util.*;

class Solution {
    
    class current {
        String word;
        int cnt;
        
        current(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    int getDifCnt(String now, String next) {
        int difCnt = 0;
        for(int i=0; i<now.length(); i++) {
            if(now.charAt(i) != next.charAt(i)) {
                difCnt++;
            }
        }
        return difCnt;
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<current> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        queue.add(new current(begin, 0));
        while(!queue.isEmpty()) {
            current cur = queue.poll();
            
            if(cur.word.equals(target)) {
                return cur.cnt;
            }
            
            for(int i=0; i<words.length; i++) {
                if(getDifCnt(cur.word, words[i]) == 1) {
                    if(!visited[i]) {
                        queue.add(new current(words[i], cur.cnt+1));
                        visited[i] = true;
                    }
                }
            }
        }
        return 0;
    }
}