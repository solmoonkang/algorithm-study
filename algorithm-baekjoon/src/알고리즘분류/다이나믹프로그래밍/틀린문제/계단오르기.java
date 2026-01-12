package 알고리즘분류.다이나믹프로그래밍.틀린문제;

import java.io.*;

public class 계단오르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int stairsNumber = Integer.parseInt(bufferedReader.readLine());

        int[] stairScores = new int[stairsNumber];
        for (int i = 0; i < stairsNumber; i++) stairScores[i] = Integer.parseInt(bufferedReader.readLine());

        int maxTotalScore = getMaxTotalScoreStairClimbingGame(stairScores);
        bufferedWriter.write(String.valueOf(maxTotalScore));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxTotalScoreStairClimbingGame(int[] stairScores) {
        // 대부분의 DP 문제에서는 1-based 인덱스를 사용하는 경우가 많다.
        // 1번째 계단부터 시작하므로, 배열의 0번 인덱스는 사용하지 않을 수 있지만, 0번 인덱스를 두면, 나중에 DP 계산을 할 때 인덱스 접근이 더 간단해질 수 있다.
        int[] dp = new int[stairScores.length];

        // 한 계단씩 오르는 경우: dp[i] = dp[i - 1] + stairScores[i - 1]
        dp[0] = stairScores[0];

        // 두 계단씩 오르는 경우: dp[i] = dp[i - 2] + stairScores[i - 1]
        dp[1] = stairScores[0] + stairScores[1];

        for (int i = 2; i < stairScores.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + stairScores[i]);
            if (i > 2) dp[i] = Math.max(dp[i], dp[i - 3] + stairScores[i - 1] + stairScores[i]);
        }

        return dp[stairScores.length - 1];
    }
}
