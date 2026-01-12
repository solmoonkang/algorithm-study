package 모든문제.level2.복습문제;

import java.io.*;

public class 멀리뛰기 {

    private static final long MOD = 1234567;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        long longJumpWay = getReachTheEndLongJump(N);
        bufferedWriter.write(String.valueOf(longJumpWay));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static long getReachTheEndLongJump(int N) {
        if (N == 1) return 1;
        long[] dp = new long[N + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[N];
    }
}
