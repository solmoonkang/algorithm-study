package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;

public class 계단오르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfStairs = Integer.parseInt(bufferedReader.readLine());
        int[] scoreOnStep = new int[numberOfStairs];

        for (int i = 0; i < numberOfStairs; i++) {
            scoreOnStep[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int maxScore = calculateMaxScore(scoreOnStep);
        bufferedWriter.write(String.valueOf(maxScore));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateMaxScore(int[] scoreOnStep) {
        // 초기화:
        int[] dp = new int[scoreOnStep.length];

        // 기저 상태:
        dp[0] = scoreOnStep[0];
        if (scoreOnStep.length > 1) dp[1] = scoreOnStep[0] + scoreOnStep[1];
        if (scoreOnStep.length > 2) dp[2] = Math.max(dp[1], dp[0] + scoreOnStep[2]);

        // 점화식:
        for (int i = 3; i < scoreOnStep.length; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + scoreOnStep[i], dp[i - 3] + scoreOnStep[i - 1] + scoreOnStep[i]));
        }

        // 마지막 계단의 점수를 포함하여 반환
        return dp[scoreOnStep.length - 1];
    }
}
