package baekjoon.단계문제.스택큐덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> cardDeque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            cardDeque.offerLast(i);
        }

        while (cardDeque.size() != 1) {
            cardDeque.pollFirst();
            cardDeque.offerLast(cardDeque.pollFirst());
        }

        bufferedWriter.write(String.valueOf(cardDeque.getFirst()));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
