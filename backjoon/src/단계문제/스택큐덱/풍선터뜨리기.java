package 단계문제.스택큐덱;

import java.io.*;
import java.util.*;

public class 풍선터뜨리기 {

    // TODO: 제시한 입력값에 따른 결과값은 맞지만 백준에서는 틀렸음. 코드를 수정해야 함.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> balloonDeque = new ArrayDeque<>();
        int[] balloonLocation = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            balloonDeque.offerLast(i + 1);
            balloonLocation[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        StringBuilder builder = new StringBuilder();
        builder.append("1 ");
        balloonDeque.pollFirst();

        int currentIndex = balloonLocation[0];

        while (!balloonDeque.isEmpty()) {
            if (currentIndex > 0) {
                for (int i = 0; i < currentIndex - 1; i++) {
                    balloonDeque.offerLast(balloonDeque.pollFirst());
                }

                int nextIndex = balloonDeque.pollFirst();
                currentIndex = balloonLocation[nextIndex - 1];
                builder.append(nextIndex).append(" ");
            } else {
                for (int i = 0; i < -currentIndex; i++) {
                    balloonDeque.offerFirst(balloonDeque.pollLast());
                }

                int nextIndex = balloonDeque.pollLast();
                currentIndex = balloonLocation[nextIndex - 1];
                builder.append(nextIndex).append(" ");
            }
        }

        bufferedWriter.write(builder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
