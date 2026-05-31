import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int n = friends.length;
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(friends[i], i);
        }

        int[][] giftCount = new int[n][n];
        int[] giftScore = new int[n];

        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int from = idxMap.get(parts[0]);
            int to = idxMap.get(parts[1]);

            giftCount[from][to]++;
            giftScore[from]++;
            giftScore[to]--;
        }
        
        int[] nextGift = new int[n];
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int a = giftCount[i][j];
                int b = giftCount[j][i];
                
                if(a > b) {
                    nextGift[i]++;
                } else if(b > a) {
                    nextGift[j]++;
                } else {
                    if(giftScore[i] > giftScore[j]) {
                        nextGift[i]++;
                    } else if(giftScore[i] < giftScore[j]) {
                        nextGift[j]++;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int g : nextGift) {
            answer = Math.max(g, answer);
        }
        
        
        return answer;
    }
}