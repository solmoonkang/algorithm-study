package baekjoon.단계문제.스택큐덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 풍선터뜨리기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> balloonDeque = new ArrayDeque<>();
        int[] values = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            balloonDeque.offerLast(i + 1);
            values[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        StringBuilder builder = new StringBuilder();

        int currentIndex = 0;

        while (!balloonDeque.isEmpty()) {
            int balloonNumber = balloonDeque.pollFirst();
            builder.append(balloonNumber).append(" ");

            int move = values[balloonNumber - 1];
            if (balloonDeque.isEmpty()) break;

            if (move > 0) currentIndex = (move - 1) % balloonDeque.size();
            else currentIndex = (balloonDeque.size() + move) % balloonDeque.size();

            for (int i = 0; i < currentIndex; i++) {
                balloonDeque.offerLast(balloonDeque.pollFirst());
            }
        }

        bufferedWriter.write(builder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
