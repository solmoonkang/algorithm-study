package 알고리즘분류.게임이론;

import java.io.*;

public class 베스킨라빈스31 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        getBaskinRobbinsGame(A, stringBuilder);

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 각 플레이어는 1개 이상, N개 이하의 연속된 숫자를 말할 수 있다. 마지막 31을 말하는 사람이 진다.
     * 이를 위해선 (N+1)의 배수 + 1 위치에서 끝나도록 숫자를 말해야 한다.
     * - 예를 들어, N=2일 때, 필승 위치는 3의 배수 + 1인 1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31이다.
     * - 예를 들어, N=3일 때, 필승 위치는 4의 배수 + 1인 1, 5, 9, 13, 17, 21, 25, 29이다.
     */
    private static void getBaskinRobbinsGame(int numericRange, StringBuilder stringBuilder) {
        for (int N = 1; N <= numericRange + 1; N++) {
            if (31 % (N + 1) == 1) stringBuilder.append(N).append("\n");
        }
    }
}
