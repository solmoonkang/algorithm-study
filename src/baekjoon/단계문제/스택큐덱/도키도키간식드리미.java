package baekjoon.단계문제.스택큐덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 도키도키간식드리미 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> sequenceDeque = new ArrayDeque<>();

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int sequence = 1;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            sequenceDeque.offerLast(number);

            while (!sequenceDeque.isEmpty() && sequenceDeque.peekLast() == sequence) {
                sequenceDeque.pollLast();
                sequence++;
            }
        }

        bufferedWriter.write(sequenceDeque.isEmpty() ? "Nice" : "Sad");

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
