package programmers.kit.queue;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 프로세스 {

    public int solution_deque(int[] priorities, int location) {

        Deque<Integer> priority = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {

            priority.offerLast(i);
        }

        int answer = 0;

        while (!priority.isEmpty()) {

            int current = priority.pollFirst();

            boolean isHigherPriorityExists = false;

            for (int index : priority) {

                if (priorities[index] > priorities[current]) {

                    isHigherPriorityExists = true;
                    break;
                }
            }

            if (isHigherPriorityExists) {

                priority.offerLast(current);
            }

            else {

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
