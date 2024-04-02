package studying_algorithm.stackqueue.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class StockPrice {     // Review Required

    public int[] solution_deque(int[] prices) {

        int[] answer = new int[prices.length];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {

            int currentPrice = prices[i];

            // 가격이 떨어진 경우,
            while (!deque.isEmpty() && prices[deque.peekLast()] > currentPrice) {

                // 덱의 마지막 원소를 꺼내고
                int prevIndex = deque.pollLast();

                // 가격이 떨어지지 않은 기간을 계산하고 새 인덱스를 추가
                answer[prevIndex] = i - prevIndex;
            }

            // 현재 인덱스를 덱에 추가
            deque.offerLast(i);
        }

        // 주식 가격 배열을 모두 순회한 후, 덱에 남은 인덱스를 처리
        while (!deque.isEmpty()) {

            // 첫 번째 원소부터 꺼내서
            int remainIndex = deque.pollFirst();

            // 끝까지 떨어지지 않은 기간을 저장
            answer[remainIndex] = prices.length - 1 - remainIndex;
        }

        return answer;
    }

    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        for (int i = 0; i < answer.length; i++) {

            for (int j = i + 1; j < answer.length; j++) {

                answer[i]++;

                if (prices[i] > prices[j]) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        StockPrice stockPrice = new StockPrice();

        int[] prices = {1, 2, 3, 2, 3};

        System.out.println("Result : " + Arrays.toString(stockPrice.solution_deque(prices)));
        System.out.println("Result : " + Arrays.toString(stockPrice.solution(prices)));
    }
}
