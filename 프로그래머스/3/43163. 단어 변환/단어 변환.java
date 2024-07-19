import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<WordState> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        queue.offer(new WordState(begin, 0));
        
        while (!queue.isEmpty()) {
            // 방문
            WordState cur = queue.poll();
            
            // 방문한 곳이 찾던 target
            if (cur.word.equals(target)) return cur.cnt;
            
            // nextvertex 예약
            for (int i=0; i<words.length; i++) {
                if (getDiffCount(cur.word, words[i]) == 1) {
                    if (!visited[i]) {
                        queue.offer(new WordState(words[i], cur.cnt+1));
                        visited[i] = true;
                    }
                }
            }
        }
        return 0;
    }
    
    int getDiffCount(String word, String target) {
        int diffCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) diffCount++;
        }
        
        return diffCount;
    }
    
    class WordState {
        String word;
        int cnt;
        
        WordState(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}