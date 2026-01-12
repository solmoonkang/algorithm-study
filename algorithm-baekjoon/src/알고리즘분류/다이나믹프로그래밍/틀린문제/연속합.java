package 알고리즘분류.다이나믹프로그래밍.틀린문제;

import java.io.*;
import java.util.StringTokenizer;

public class 연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] sequences = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) sequences[i] = Integer.parseInt(stringTokenizer.nextToken());

        int maxSum = getMaxSumConsecutiveNumber(N, sequences);
        bufferedWriter.write(String.valueOf(maxSum));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxSumConsecutiveNumber(int N, int[] sequences) {
        int[] dp = new int[N];

        dp[0] = sequences[0];

        int maxSum = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(sequences[i], dp[i - 1] + sequences[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
