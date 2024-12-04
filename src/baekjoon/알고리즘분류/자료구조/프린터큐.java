package baekjoon.알고리즘분류.자료구조;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 프린터큐 {

    // TODO: 나머지 문서들 중에서 현재 문서보다 높은 중요도를 확인하는 부분, 다시 한 번 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            Deque<int[]> deque = new LinkedList<>();

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int number = 0; number < N; number++) {
                int priority = Integer.parseInt(stringTokenizer.nextToken());
                deque.offerLast(new int[]{priority, number});
            }

            int printOrder = 0;

            while (!deque.isEmpty()) {
                int[] current = deque.pollFirst();
                boolean hasHigherPriority = false;

                for (int[] doc : deque) {
                    if (doc[0] > current[0]) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    deque.offerLast(current);
                } else {
                    printOrder++;
                    if (current[1] == M) bufferedWriter.write(printOrder + "\n");
                }
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
