package programmers.알고리즘고득점KIT.스택_큐;

import java.util.*;

public class 기능개발 {

    public int[] solution_que(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {

            if ((100 - progresses[i]) % speeds[i] == 0) {

                queue.offer((100 - progresses[i]) / speeds[i]);
            } else {

                queue.offer((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        int x = queue.poll();
        int count = 1;

        while (!queue.isEmpty()) {

            if (x >= queue.peek()) {

                count++;

                queue.poll();
            } else {

                list.add(count);

                count = 1;

                x = queue.poll();
            }
        }

        list.add(count);

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {

            answer[i] = list.get(i);
        }

        return answer;
    }






    public int[] solution_deque(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {

            if ((100 - progresses[i]) % speeds[i] == 0) {

                deque.offerLast((100 - progresses[i]) / speeds[i]);
            } else {

                deque.offerLast((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        int x = deque.pollFirst();
        int count = 1;

        while (!deque.isEmpty()) {

            if (x >= deque.peekFirst()) {

                count++;

                deque.pollFirst();
            } else {

                list.add(count);

                count = 1;

                x = deque.pollFirst();
            }
        }

        list.add(count);

        int[] answer = list.stream().mapToInt(o -> o).toArray();

        return answer;
    }

    public static void main(String[] args) {

        기능개발 develop = new 기능개발();

        int[] progresses = {93, 30, 55};

        int[] speeds = {1, 30, 5};

        System.out.println("Result : " + Arrays.toString(develop.solution_que(progresses, speeds)));
        System.out.println("Result : " + Arrays.toString(develop.solution_deque(progresses, speeds)));
    }
}
