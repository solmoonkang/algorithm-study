package 알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;

public class 피보나치수_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int fibonacciNumber = generateFibonacciNumber(N);
        bufferedWriter.write(String.valueOf(fibonacciNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int generateFibonacciNumber(int N) {
        int[] dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= N; i++) dp[i] = dp[i - 1] + dp[i - 2];

        return dp[N];
    }
}
