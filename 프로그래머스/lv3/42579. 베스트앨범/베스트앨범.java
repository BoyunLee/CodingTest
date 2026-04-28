import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        String genre;
        int play;
        int index;
        
        Node(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }
        
        @Override
        public int compareTo(Node n) {
            if (this.play != n.play) {
                return n.play - this.play;
            }
            return this.index - n.index;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, PriorityQueue<Node>> songMap = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            String type = genres[i];
            if(map.containsKey(type)) {
                map.put(type, map.get(type) + plays[i]);
            } else {
                map.put(type, plays[i]);
                songMap.put(type, new PriorityQueue<Node>());
            }
            songMap.get(type).add(new Node(type, plays[i], i));
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
                     
        for (int i = 0; i < list.size(); i++) {
            String genre = list.get(i).getKey();

            PriorityQueue<Node> pq = songMap.get(genre);

            int cnt = 0;
            while (!pq.isEmpty() && cnt < 2) {
                answer.add(pq.poll().index);
                cnt++;
            }
        }
        
        int[] end = new int[answer.size()];
        for(int i=0; i<answer.size(); i++) {
            end[i] = answer.get(i);
        }
        return end;
    }
}