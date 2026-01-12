package 모든문제.level2;

import java.io.*;

public class 멀리뛰기 {

    private static final long MOD = 1234567;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        long way = getReachTheEndWay(N);
        bufferedWriter.write(String.valueOf(way));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static long getReachTheEndWay(int N) {
        long a = 1, b = 1;

        for (int i = 2; i <= N; i++) {
            long answer = (a + b) % MOD;
            a = b;
            b = answer;
        }

        return b;
    }

    private static long getReachTheEndWayWithDP(int N) {
        long[] dp = new long[N + 2];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[N];
    }
}
