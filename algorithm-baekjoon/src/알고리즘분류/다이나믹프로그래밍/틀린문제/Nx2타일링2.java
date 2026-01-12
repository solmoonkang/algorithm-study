package 알고리즘분류.다이나믹프로그래밍.틀린문제;

import java.io.*;

public class Nx2타일링2 {

    private static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int numberWay = getFillRectangleNumberWay(N);
        bufferedWriter.write(String.valueOf(numberWay));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getFillRectangleNumberWay(int N) {
        // 2xi 크기의 직사각형을 채우는 경우의 수를 저장한다.
        int[] dp = new int[N + 1];

        // 2x1 직사각형은 2x1 타일 1개로만 채울 수 있다.
        if (N >= 1) dp[1] = 1;
        // 2x2 직사각형은 2x1 타일 2개, 1x2 타일 2개, 또는 2x2 타일 1개로 채울 수 있다.
        if (N >= 2) dp[2] = 3;

        // 점화식은 마지막에 놓는 타일의 종류에 따라 경우의 수를 나누어 생각한다.
        for (int i = 3; i <= N; i++) {
            // 마지막에 2x1 타일을 세로로 놓는 경우: 이전에 남아있는 부분은 2 * (i - 1) 직사각형이다.
            // 마지막에 1x2 타일을 가로로 놓는 경우: 이전에 남아있는 부분은 2 * (i - 2) 직사각형이다.
            // 마지막에 2x2 타일을 1개 놓는 경우: 이전에 남아있는 부분은 2 * (i - 2) 직사각형이다.
            // 마지막에 놓는다: 2xi 크기의 직사각형을 채울 때, 마지막 부분을 채우는 방법을 생각해본다는 의미이다.
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % MOD;
        }

        return dp[N];
    }
}
