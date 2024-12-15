package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;

public class Nx2타일링 {

    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int numberOfTilingWay = fillRectangleWithTiles(N);
        bufferedWriter.write(String.valueOf(numberOfTilingWay));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int fillRectangleWithTiles(int number) {
        int[] dp = new int[number + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= number; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[number];
    }
}
