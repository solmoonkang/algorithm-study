package baekjoon.알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class 이친수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int pinaryNumber = countPinaryNumbers(N);
        bufferedWriter.write(String.valueOf(pinaryNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // TODO: 점화식 계산이 잘못되어 틀렸음. 다시 풀어보자.
    private static int countPinaryNumbers(int N) {
        int[] dp = new int[N + 1];

        // 기저 상태: N = 1일 때 "1", N = 2일 때 "10"
        dp[1] = 1;
        if (N >= 2) dp[2] = 1;

        // 0과 1로 만들 수 있는 N개의 자리 모든 부분 문자열을 구하고, 그 수를 dp 배열에 저장한다.
        for (int i = 3; i <= N; i++) dp[i] = dp[i - 1] + dp[i - 2];

        return dp[N];
    }
}
