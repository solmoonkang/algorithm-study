package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;

public class 일이삼더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());

            int countWay = countWayToSum(N);
            bufferedWriter.write(countWay + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int countWayToSum(int number) {
        // 초기화
        int[] dp = new int[number + 1];

        // 기저 상태
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        // 점화식
        for (int i = 3; i <= number; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[number];
    }
}
