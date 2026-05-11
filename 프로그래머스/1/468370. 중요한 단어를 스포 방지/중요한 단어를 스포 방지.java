import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        boolean[] spoiler = new boolean[n];

        for (int[] r : spoiler_ranges) {
            for (int i = r[0]; i <= r[1]; i++) {
                spoiler[i] = true;
            }
        }

        Set<String> nonSpoilerWords = new HashSet<>();
        int i = 0;
        while (i < n) {
            while (i < n && message.charAt(i) == ' ') i++;
            if (i >= n) break;
            int start = i;
            while (i < n && message.charAt(i) != ' ') i++;
            int end = i;

            boolean hasSpoiler = false;
            for (int j = start; j < end; j++) {
                if (spoiler[j]) { 
                    hasSpoiler = true; 
                    break; 
                }
            }
            if (!hasSpoiler) {
                nonSpoilerWords.add(message.substring(start, end));
            }
        }

        int answer = 0;
        Set<String> seen = new HashSet<>();
        i = 0;
        while (i < n) {
            while (i < n && message.charAt(i) == ' ') i++;
            if (i >= n) break;
            int start = i;
            while (i < n && message.charAt(i) != ' ') i++;
            int end = i;

            boolean isSpoiler = false;
            for (int j = start; j < end; j++) {
                if (spoiler[j]) { 
                    isSpoiler = true; 
                    break; 
                }
            }

            if (isSpoiler) {
                String word = message.substring(start, end);
                if (!nonSpoilerWords.contains(word) && !seen.contains(word)) {
                    answer++;
                    seen.add(word);
                }
            }
        }
        return answer;
    }
}