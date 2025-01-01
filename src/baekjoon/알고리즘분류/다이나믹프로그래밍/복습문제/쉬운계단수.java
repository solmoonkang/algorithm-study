package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;

public class 쉬운계단수 {

    private static final int MOD = 1_000_000_000;
    private static final int NUMBER_RANGE = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        long stairNumber = countStairNumbers(N);
        bufferedWriter.write(String.valueOf(stairNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static long countStairNumbers(int N) {
        // 초기화: dp[length][lastDigit]로 길이가 length인 계단 수 중 마지막 숫자가 lastDigit인 경우의 수를 저장한다.
        long[][] dp = new long[N + 1][NUMBER_RANGE + 1];

        // 기저 상태: 길이가 1인 계단 수는 1부터 9까지의 각 숫자 하나씩 저장된다.
        for (int i = 1; i <= NUMBER_RANGE; i++) dp[1][i] = 1;

        // 점화식: 길이가 N인 계단 수를 만들기 위해 길이가 N-1인 계단 수를 고려한다.
        // 마지막 숫자가 lastDigit일 때, 가능한 마지막 숫자는 lastDigit - 1 또는 lastDigit + 1이다.

        // 외부 반복문: 현재 길이 N의 계단 수를 계산하기 위해 길이를 2부터 N까지 증가시키며 반복한다.
        // 내부 반복문: 마지막 자리 숫자를 0부터 9까지 반복한다. 마지막 자릿수가 1일 때는 0이 올 수 없고, 9일 때는 10이 올 수 없도록 조건을 추가한다.
        for (int length = 2; length <= N; length++) {
            for (int lastDigit = 0; lastDigit <= NUMBER_RANGE; lastDigit++) {
                if (lastDigit > 0) dp[length][lastDigit] += dp[length - 1][lastDigit - 1];
                if (lastDigit < 9) dp[length][lastDigit] += dp[length - 1][lastDigit + 1];
                dp[length][lastDigit] %= MOD;
            }
        }

        long stairNumber = 0;
        for (int i = 0; i <= NUMBER_RANGE; i++) stairNumber += dp[N][i];

        return stairNumber;
    }
}
