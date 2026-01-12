package 알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        int maxLength = findLongestIncreasingSubsequence(numbers);
        bufferedWriter.write(String.valueOf(maxLength));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int findLongestIncreasingSubsequence(int[] numbers) {
        // 초기화
        int[] dp = new int[numbers.length];
        int maxLength = 0;

        // 기저 상태
        dp[0] = 1;

        // 점화식
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
