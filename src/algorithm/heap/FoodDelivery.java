package algorithm.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FoodDelivery {

    // 문제:
    // 음식 배달 회사에서 소비자들의 주문 순서를 처리해야 합니다.
    // 주문이 들어오면, 각 주문은 고유한 주문 번호와 우선순위를 갖습니다.
    // 우선순위는 1부터 5까지의 값이며, 5가 가장 높은 우선순위입니다.
    // 주어진 주문 리스트를 처리하는 프로그램을 작성하세요.

    public static void main(String[] args) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        int[][] orders = {{1, 3}, {2, 5}, {3, 1}, {4, 2}, {5, 4}};

        priorityQueue.addAll(Arrays.asList(orders));

        while (!priorityQueue.isEmpty()) {

            int[] answer = priorityQueue.poll();

            System.out.println("Result : " + Arrays.toString(answer));
        }
    }
}
