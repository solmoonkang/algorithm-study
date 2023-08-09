package programmers.kit.heap;

import java.util.PriorityQueue;

public class 더맵게 {

    // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + ( 두 번째로 맵지 않은 음식의 스코빌 지수 * 2 )

//    public int solution(int[] scoville, int K) {
//
//        int answer = 0;
//
//        // 우선순위 큐에 스코빌 지수가 담긴 음식을 넣으면, 루트노드는 가장 맵지 않은 음식의 스코빌 지수가 된다
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//
//        for (int i = 0; i < scoville.length; i++) {
//
//            priorityQueue.add(scoville[i]);
//        }
//
//        // 따라서 큐에서 값을 두 개 꺼내면, 해당 공식의 인자를 구할 수 있다
//        while (priorityQueue.peek() < K) {
//
//            if (priorityQueue.size() == 1) {
//
//                return -1;
//            }
//
//            // 두 음식을 섞어서 다시 큐에 집어넣고, 루트 노드가 K 이상일 경우 또는 더는 섞을 음식이 없을 경우까지 반복한다
//            priorityQueue.add(priorityQueue.poll() + priorityQueue.poll() * 2);
//
//            answer++;
//        }
//
//        return answer;
//    }

    public int re_solution(int[] scoville, int K) {

        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue();

        // 우선순위 큐에 스코빌 값을 넣음
        for (int i = 0; i < scoville.length; i++) {

            priorityQueue.add(scoville[i]);
        }



        System.out.println(priorityQueue);

        return answer;
    }

    public static void main(String[] args) {

        int[] scoville = {1, 2, 3, 9, 10, 12};

        더맵게 moreSpicy = new 더맵게();

        System.out.println("Result : " + moreSpicy.re_solution(scoville, 2));
    }
}
