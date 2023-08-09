package programmers.kit.queue;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 프로세스 {

    // Deque 나 Priority Queue 를 사용해서 구현할 수 있을거 같다

    public int solution_deque(int[] priorities, int location) {

        Deque<Integer> deque = new LinkedList<>();

        int answer = 0;

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

        int[] priorities = {2, 1, 3, 2};

        System.out.println("Result : " + process.solution_deque(priorities, 2));
        System.out.println("Result : " + process.solution_priorityQue(priorities, 2));
    }
}
