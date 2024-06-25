import java.util.LinkedList;
import java.util.Queue;

class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {

            // Java에서 Queue 인터페이스를 구현한 LinkedList 클래스의 인스턴스를 생성하는 코드
            // FIFO(First-In-First-Out) 데이터 구조를 나타며 이는 큐에서 가장 먼저 추가된 요소가 가장 먼저 제거되는 원리
            Queue<Integer> queue = new LinkedList<>();

            // 현재 다리 위의 트럭 무게 총합
            int sum = 0;

            // 경과 시간
            int time = 0; 

            for (int i = 0; i < truck_weights.length; i++) {
                int truck = truck_weights[i];

                while(true) {
                    // 다리 위에 트럭이 없는 경우
                    if(queue.isEmpty()) { 
                        queue.add(truck);
                        sum += truck;
                        // 다리에 오를 때만 시간 추가 
                        time++; 
                        break;
                    }else if (queue.size() == bridge_length) {
                        // 다리 위에 트럭이 다 찬 경우
                        sum -= queue.poll();
                    }else {
                        // 다리 위에 트럭이 있지만 아직 다 차지 않은 경우
                        if (sum + truck <= weight) {
                            // 다음 트럭이 다리에 진입할 수 있는 경우
                            queue.add(truck);
                            sum += truck;
                            time++;
                            break;
                        } else {
                            // 다음 트럭이 다리에 진입할 수 없는 경우
                            // 0을 추가하여 트럭이 지나가도록 함
                            queue.add(0);
                            time++;
                        }
                    }
                }
            }
            // 마지막 트럭에서 반복문이 끝나는데, 마지막 역시 다리 길이만큼 지나가야하기에 + 다리 길이 
            return time + bridge_length; 
        }
    }