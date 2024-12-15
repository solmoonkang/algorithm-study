package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;

public class 피보나치함수 {

    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            fibonacciMethod(number);
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void fibonacciMethod(int number) {
        // 초기화: N은 40보다 작거나 같은 자연수이며, 0과 1의 호출 횟수 저장을 위해 dp의 크기는 [41][2]으로 초기화한다.
        int[][] dp = new int[41][2];

        // 기저 상태
        dp[0][0] = 1;       // fibonacciMethod(0) 호출 시 0은 1번 출력된다.
        dp[0][1] = 0;       // fibonacciMethod(0) 호출 시 1은 출력되지 않는다.
        dp[1][0] = 0;       // fibonacciMethod(1) 호출 시 0은 출력되지 않는다.
        dp[1][1] = 1;       // fibonacciMethod(1) 호출 시 1은 1번 출력된다.

        // 점화식: 0과 1의 호출 횟수를 계산한다.
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        stringBuilder.append(dp[number][0]).append(" ").append(dp[number][1]).append("\n");
    }
}
