package 모든문제.level2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 주식가격 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] prices = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) prices[i] = Integer.parseInt(stringTokenizer.nextToken());

        int[] stockPrices = getStockPrices(prices);
        for (int price : stockPrices) bufferedWriter.write(price + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getStockPrices(int[] prices) {
        Deque<Integer> deque = new ArrayDeque<>();

        int[] stockPrices = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!deque.isEmpty() && prices[deque.peekLast()] > prices[i]) {
                int previousIndex = deque.pollLast();
                stockPrices[previousIndex] = i - previousIndex;
            }

            deque.offerLast(i);
        }

        while (!deque.isEmpty()) {
            int index = deque.pollLast();
            stockPrices[index] = prices.length - 1 - index;
        }

        return stockPrices;
    }

    private static int[] timeLimitExceeded(int[] prices) {
        int[] stockPrices = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int time = 0;

            for (int j = i + 1; j < prices.length; j++) {
                time++;
                if (prices[i] < prices[j]) break;
            }

            stockPrices[i] = time;
        }

        return stockPrices;
    }
}
