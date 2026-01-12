package 모든문제.level2.알고리즘고득점KIT;

import java.util.ArrayDeque;
import java.util.Deque;

public class 프로세스 {

    public int solution(int[] priorities, int location) {
        Deque<Integer> pendingExecutionDeque = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            pendingExecutionDeque.offerLast(i);
        }

        int processOrder = 0;
        while (!pendingExecutionDeque.isEmpty()) {
            int currentProcess = pendingExecutionDeque.pollFirst();
            boolean hasHigherPriority = false;

            for (int priority : pendingExecutionDeque) {
                if (priorities[priority] > priorities[currentProcess]) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) pendingExecutionDeque.offerLast(currentProcess);
            else {
                processOrder++;
                if (currentProcess == location) break;
            }
        }

        return processOrder;
    }

    public static void main(String[] args) {
        프로세스 problem = new 프로세스();

        int[] priorities1 = {2, 1, 3, 2};
        System.out.println("problem = " + problem.solution(priorities1, 2));

        int[] priorities2 = {1, 1, 9, 1, 1};
        System.out.println("problem = " + problem.solution(priorities2, 0));
    }
}
