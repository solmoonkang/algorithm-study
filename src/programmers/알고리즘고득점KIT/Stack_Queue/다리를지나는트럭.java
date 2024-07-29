package programmers.알고리즘고득점KIT.Stack_Queue;

import java.util.Deque;
import java.util.LinkedList;

public class 다리를지나는트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        // 트럭 여러 대가 일차선 다리를 정해진 순서대로 건넌다
        // 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 한다

        // 다리에는 트럭이 최대 bride_length 대 올라갈 수 있으며,
        // 다리는 weight 이하까지의 무게를 견딜 수 있다
        // ( 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시한다 )

        // 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
        // 0	       []	            []	       [7,4,5,6]
        // 1~2	       []	            [7]     	[4,5,6]
        // 3	       [7]	            [4]        	[5,6]
        // 4	       [7]          	[4,5]	     [6]
        // 5	       [7,4]         	[5]	         [6]
        // 6~7	       [7,4,5]       	[6]          []
        // 8           [7,4,5,6]	    []	         []

        // 트럭 2대가 올라갈 수 있고, 무게가 10kg 까지 견디는 다리가 있다
        // 무게가 [7, 4, 5, 6]kg 인 트럭이 순서대로 최단 시간 안에 다리를 건너려면,
        // 따라서 모든 트럭이 다리를 지나려면 최소 8초가 걸린다


        Deque<Integer> deque = new LinkedList<>();

        int time = 0;   // 트럭이 다리는 지나는 시간을 저장
        int sum = 0;    // 다리를 지나는 트럭의 무게합을 저장

        // 큐가 비어 있을 때( 다리를 건너는 트럭이 없을 때 )
        // 큐에 트럭을 추가하고, 해당 무게를 sum에 더해주고 time을 증가


        // 큐가 비어 있지 않을 때( 다리를 건너는 트럭이 있을 때 )
            // 1. 큐의 사이즈와 다리의 길이가 같을 때( 다리 위에 트럭이 다 올라가 있을 때 )
                // 가장 앞에 있는 트럭이 다리를 통과해 나갈 차례이므로 큐에서 처음 값만 빼고, 그만큼의 무게를 무게합에서 빼준다
            // 2. 다음 트럭이 최대 무게를 초과했을 때
                // 트럭의 무게 대신 0을 넣어주고 time을 증가
            // 3. 다음 트럭이 최대 무게 이내일 때


        for (int truck : truck_weights) {

            while (true) {

                // 큐가 비어 있을 경우
                if (deque.isEmpty()) {

                    deque.offerLast(truck);

                    sum += truck;

                    time++;

                    break;

                // 큐가 비어 있지 않은 경우
                } else {

                    // 큐의 사이즈와 다리의 길이가 같을 경우
                    if (deque.size() == bridge_length) {

                        sum -= deque.pollFirst();

                    // 다음 트럭이 최대 무게를 초과했을 경우
                    } else if (sum + truck > weight) {

                        deque.offerLast(0);

                        time++;

                    // 다음 트럭이 최대 무게 이내일 경우 : else
                    } else {

                        deque.offerLast(truck);

                        sum += truck;

                        time++;

                        break;
                    }
                }
            }
        }

        return time + bridge_length;
    }

    public static void main(String[] args) {

        다리를지나는트럭 truck = new 다리를지나는트럭();

        int[] first_truck_weight = {7, 4, 5, 6};
        int[] second_truck_weight = {10};
        int[] third_truck_weight = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        System.out.println("First Result : " + truck.solution(2, 10, first_truck_weight));
        System.out.println("Second Result : " + truck.solution(100, 100, second_truck_weight));
        System.out.println("Third Result : " + truck.solution(100, 100, third_truck_weight));
    }
}
