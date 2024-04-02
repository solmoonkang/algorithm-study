package studying_algorithm.stackqueue.queue;

import java.util.Deque;
import java.util.LinkedList;

public class ATruckOverABridge {     // Review Required

    /**
     * [ 고려해야 할 조건 ]
     * 다리에는 트럭이 최대 bridge_length 까지 올라갈 수 있으며, 다리는 weight 이하까지 무게를 견딜 수 있다
     * 트럭이 다리에 올라가면, 1초가 시작된다
     * 이후, 다리 위에서 1칸씩 움직일 때마다 1초가 흘러간다
     *
     * [ 다리에 트럭을 넣는 조건 ]
     * 큐가 비어있을 경우
     * 큐가 ( 다리 길이만큼 ) 가득 차지 않은 경우
     * 큐가 가득찬 경우
     */

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Deque<Integer> deque = new LinkedList<>();

        int sum = 0;    // 현재 다리 위의 트럭들의 무게 합
        int time = 0;   // 시간

        for (int truck : truck_weights) {

            while (true) {

                // 다리 위에 트럭이 없을 경우
                if (deque.isEmpty()) {

                    // 현재 트럭을 덱에 추가
                    deque.offerLast(truck);

                    // 현재 다리 위 트럭의 무게를 저장
                    sum += truck;

                    // 시간을 증가
                    time++;

                    break;
                }

                // 다리가 가득 찬 경우
                else if (deque.size() == bridge_length) {

                    // 빠져나온 트럭의 무게를 무게 합에서 뺌
                    sum -= deque.pollFirst();
                }

                // 다리 길이만큼 트럭이 차지 않을 경우
                else {

                    // 트럭이 다리 위의 최대 중량을 초과하지 않을 경우
                    if (sum + truck <= weight) {

                        // weight 값을 넘지 않는 선에서 새로운 트럭을 다리에 올려줌
                        deque.offerLast(truck);

                        sum += truck;

                        time++;

                        break;
                    }

                    // 트럭이 다리 위의 최대 중량을 초과할 경우
                    else {

                        // weight 값을 넘는다면, 0을 넣어서 이미 덱에 있는 트럭이 다리를 건너게 만듬
                        deque.offerLast(0);

                        time++;
                    }
                }
            }
        }

        // 마지막 트럭이 다리를 완전히 건너야 하므로, 다리의 길이만큼 시간을 더해서 반환
        return time + bridge_length;
    }

    public static void main(String[] args) {

        ATruckOverABridge truck = new ATruckOverABridge();

        int[] truck_weights1 = {7, 4, 5, 6};
        int[] truck_weights2 = {10};
        int[] truck_weights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        System.out.println("Result1 : " + truck.solution(2, 10, truck_weights1));
        System.out.println("Result2 : " + truck.solution(100, 100, truck_weights2));
        System.out.println("Result3 : " + truck.solution(100, 100, truck_weights3));
    }
}
