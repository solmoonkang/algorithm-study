package baekjoon.알고리즘분류.구현;

import java.io.*;

public class 별찍기_9 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        /**
         * 1. 첫 번째 반복문
         *  - i는 0부터 시작하여 N-1까지 반복된다. 각 i는 현재 줄의 인덱스를 나타낸다.
         *  - 이 반복문은 N개의 줄을 출력한다.
         * 2. 공백 출력
         *  - j는 0부터 i-1까지 반복된다. 즉, 현재 줄의 인덱스 i에 따라 공백의 개수가 증가한다.
         *  - 첫 번째 줄 (i = 0)에서는 공백이 0개, 두 번째 줄 (i = 1)에서는 1개, N번째 줄 (i = N)에서는 N-1개의 공백이 출력된다.
         * 3. 별 출력
         *  - 별의 개수는 2 * (N - i) - 1로 계산된다.
         *      - 첫 번째 줄 (i = 0)에서는 2 * (N - 0) - 1 = 2 * N - 1개의 별을 출력한다.
         *      - 두 번째 줄 (i = 1)에서는 2 * (N - 1) - 1 = 2 * (N - 1)개의 별을 출력한다.
         *      - 이처럼 각 줄마다 별의 개수가 2개씩 줄어들게 된다.
         */
        for (int i = 0; i < N; i++) {
            stringBuilder.append(" ".repeat(i));
            stringBuilder.append("*".repeat(Math.max(0, 2 * N - (2 * i) - 1)));
            stringBuilder.append("\n");
        }

        for (int i = 1; i < N; i++) {
            stringBuilder.append(" ".repeat(Math.max(0, N - 1 - i)));
            stringBuilder.append("*".repeat(Math.max(0, 2 * i + 1)));
            stringBuilder.append("\n");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
