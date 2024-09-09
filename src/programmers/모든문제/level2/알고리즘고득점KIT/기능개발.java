package programmers.모든문제.level2.알고리즘고득점KIT;

import java.util.*;

public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> deployProgress = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            deployProgress.offerLast((100 - progresses[i] + speeds[i] - 1) / speeds[i]);
        }

        while (!deployProgress.isEmpty()) {
            int firstTask = deployProgress.pollFirst();
            int taskCount = 1;

            while (!deployProgress.isEmpty() && deployProgress.peekFirst() <= firstTask) {
                deployProgress.pollFirst();
                taskCount++;
            }

            answer.add(taskCount);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        기능개발 problem = new 기능개발();

        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        System.out.println("problem = " + Arrays.toString(problem.solution(progresses1, speeds1)));

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        System.out.println("problem = " + Arrays.toString(problem.solution(progresses2, speeds2)));
    }
}
