package studying_algorithm.heap;

import java.util.PriorityQueue;

public class MoreSpicy {

    public int solution(int[] sco, int K) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int answer = 0;

        for (int i = 0; i < sco.length; i++) {

            priorityQueue.offer(sco[i]);
        }

        while (priorityQueue.peek() < K) {

            // 만약, 가장 낮은 점수를 더 이상 섞을 수 없음을 판단
            if (priorityQueue.size() == 1) {

                return -1;
            }

            priorityQueue.offer(priorityQueue.poll() + (priorityQueue.poll() * 2));

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {

        MoreSpicy spicy = new MoreSpicy();

        int[] sco = {1, 2, 3, 9, 10, 12};

        System.out.println("Result : " + spicy.solution(sco, 7));
    }
}
