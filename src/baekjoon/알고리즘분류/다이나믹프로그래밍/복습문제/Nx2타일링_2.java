package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;

public class Nx2타일링_2 {

    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int tileFillingWays = generateTileFillingWays(N);
        bufferedWriter.write(String.valueOf(tileFillingWays));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int generateTileFillingWays(int N) {
        // 초기화: N의 범위가 1부터 1,000까지의 범위이므로 N + 1로 초기화를 하거나, 배열의 크기를 고정적으로 1,000 + 1 크기로 초기화할 수 있다.
        int[] dp = new int[N + 1];

        // 기저 상태: dp[0]은 아무것도 채울 수 없고, dp[1]은 1x2 타일을 세로로 놓을 경우와 2x1 타일을 가로로 놓을 경우로 총 2가지이다.
        dp[0] = 1; dp[1] = 1;

        // 점화식:
        for (int i = 2; i <= N; i++) dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % MOD;

        return dp[N];
    }
}
