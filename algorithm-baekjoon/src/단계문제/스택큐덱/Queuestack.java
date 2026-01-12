package 단계문제.스택큐덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Queuestack {

    // TODO: 제시한 입력값에 따른 결과값은 맞지만 백준에서는 시간초과가 떴음. 코드를 수정해야 함.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] stackOrQue = new int[N];
        Deque<Integer> questack = new ArrayDeque<>();

        StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
        StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            stackOrQue[i] = Integer.parseInt(stringTokenizer1.nextToken());
            questack.offerLast(Integer.parseInt(stringTokenizer2.nextToken()));
        }

        int M = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer numberTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] answer = new int[M];
        for (int i = 0; i < M; i++) {
            int element = Integer.parseInt(numberTokenizer.nextToken());
            int currentElement = element;

            for (int j = 0; j < N; j++) {
                if (stackOrQue[j] == 0) {
                    questack.offerLast(currentElement);
                    currentElement = questack.pollFirst();
                } else {
                    questack.offerLast(currentElement);
                    currentElement = questack.pollLast();
                }
            }

            answer[i] = currentElement;
        }

        for (int i = 0; i < M; i++) {
            bufferedWriter.write(answer[i] + (i == M - 1 ? "" : " "));
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
