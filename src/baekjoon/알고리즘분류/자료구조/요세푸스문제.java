package baekjoon.알고리즘분류.자료구조;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 요세푸스문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }

        stringBuilder.append("<");

        while (!deque.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                deque.offerLast(deque.pollFirst());
            }

            if (deque.size() == 1) stringBuilder.append(deque.pollFirst());
            else stringBuilder.append(deque.pollFirst()).append(", ");
        }

        stringBuilder.append(">");

        bufferedWriter.write(stringBuilder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
