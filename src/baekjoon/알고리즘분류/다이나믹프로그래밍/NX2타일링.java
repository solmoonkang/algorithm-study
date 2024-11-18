package baekjoon.알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class NX2타일링 {

    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int tileCount = countWaysToTile(N);

        bufferedWriter.write(String.valueOf(tileCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int countWaysToTile(int number) {
        int[] dp = new int[number + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= number; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[number];
    }
}
