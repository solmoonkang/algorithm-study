package 모든문제.level2;

import java.io.*;

public class 피보나치수 {

    private static final int MOD = 1234567;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int fibonacciNumber = generateFibonacciNumberWithDP(N);
        bufferedWriter.write(String.valueOf(fibonacciNumber));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int generateFibonacciNumberWithDP(int N) {
        int[] dp = new int[N + 1];

        dp[0] = 0;
        if (N >= 1) dp[1] = 1;
        if (N >= 2) dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[N];
    }

    /**
     * 피보나치 수열을 dp를 사용해 계산한다면 이전 두 값이 필요하므로 배열 없이 int a, int b로 처리하면 공간 복잡도 O(1)을 가진다.
     */
    private static int generateFibonacciNumber(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;

        int a = 0, b = 1;

        for (int i = 2; i <= N; i++) {
            int temp = (a + b) % MOD;
            a = b;
            b = temp;
        }

        return b;
    }
}
