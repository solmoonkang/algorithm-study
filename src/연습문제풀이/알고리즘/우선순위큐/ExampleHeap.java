package 연습문제풀이.알고리즘.우선순위큐;

import java.util.PriorityQueue;

public class ExampleHeap {

    public int solution(int[] scoville, int K) {

        int answer = 0;

        // 우선순위 큐는 기본적으로 낮은 숫자를 우선순위로 설정
        // Queue 와 동일하여 FIFO 형태의 구조를 갖음
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {

            priorityQueue.add(scoville[i]);
        }

        while (priorityQueue.peek() < K) {

            // 만약, 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우,
            if (priorityQueue.size() == 1) {

                // -1 을 반환
                return -1;
            }

            priorityQueue.add(priorityQueue.poll() + (priorityQueue.poll() * 2));

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {

        ExampleHeap heap = new ExampleHeap();

        int[] scoville = {1,2,3,9,10,12};

        System.out.println("Scoville : " + heap.solution(scoville, 7));
    }
}
