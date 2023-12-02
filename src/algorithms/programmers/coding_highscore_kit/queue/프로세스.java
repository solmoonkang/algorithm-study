package algorithms.programmers.coding_highscore_kit.queue;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 프로세스 {

    public int solution_deque(int[] priorities, int location) {

        // 큐에 대기중인 프로세스를 저장
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            deque.offerLast(i);
        }

        int answer = 0;

        while (!deque.isEmpty()) {

            int current = deque.pollFirst();
            boolean isHigherPriorityExists = false;

            for (int index : deque) {

                if (priorities[index] > priorities[current]) {
                    isHigherPriorityExists = true;
                    break;
                }
            }

            // 만약, 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있을 경우
            if (isHigherPriorityExists) {
                // 방금 꺼낸 프로세스를 다시 큐에 넣음
                deque.offerLast(current);
            }

            // 만약, 대기중인 프로세스가 가장 높은 우선순위인 경우
            else {
                // 해당 프로세스를 실행
                answer++;

                if (current == location) {
                    break;
                }
            }
        }

        return answer;
    }

    public int solution_priorityQue(int[] priorities, int location) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {

            priorityQueue.add(priorities[i]);
        }

        while (!priorityQueue.isEmpty()) {

            for (int i = 0; i < priorities.length; i++) {

                if (priorities[i] == priorityQueue.peek()) {

                    if (i == location) {

                        answer++;

                        return answer;
                    }

                    priorityQueue.poll();

                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        프로세스 process = new 프로세스();

        int[] priorities = {1, 1, 9, 1, 1, 1};

        System.out.println("Result : " + process.solution_deque(priorities, 0));
//        System.out.println("Result : " + process.solution_priorityQue(priorities, 2));
    }
}
