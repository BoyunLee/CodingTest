import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        int len=operations.length;
        int size=0;
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        
        for(int i=0;i<len;i++){
            String[] op=operations[i].split(" ");
            int target=Integer.parseInt(op[1]);
            if(op[0].equals("I")){
                tm.put(target,tm.getOrDefault(target,0)+1);
                size++;
            }
            else{
                if(size<1)
                    continue;
                if(target>0){
                    int max=tm.lastKey();
                    if(tm.get(max)==1)
                        tm.remove(max);
                    else{
                        tm.put(max,tm.get(max)-1);
                    }
                    size--;
                }
                else{
                    int min=tm.firstKey();
                    if(tm.get(min)==1)
                        tm.remove(min);
                    else{
                        tm.put(min,tm.get(min)-1);
                    }
                    size--;
                }
            }
        }
        // PriorityQueue<Integer> maxq=new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Integer> minq=new PriorityQueue<>();
        // int size=0;
        // for(int i=0;i<len;i++){
        //     String[] op=operations[i].split(" ");
        //     int target=Integer.parseInt(op[1]);
        //     if(op[0].equals("I")){
        //         maxq.add(target);
        //         minq.add(target);
        //         size++;
        //     }
        //     else{
        //         if(target>0&&size>0){
        //             maxq.poll();
        //             size--;
        //         }
        //         if(target<0&&size>0){
        //             minq.poll();
        //             size--;
        //         }
        //     }
        // }
        if(size==0)
            return answer;
        else{
            answer[0]=(tm.lastKey());
            answer[1]=(tm.firstKey());
            return answer;
        }
        //return answer;
    }
}