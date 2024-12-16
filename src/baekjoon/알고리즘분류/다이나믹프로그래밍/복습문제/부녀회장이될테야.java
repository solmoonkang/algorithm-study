package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;

public class 부녀회장이될테야 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(bufferedReader.readLine());
            int N = Integer.parseInt(bufferedReader.readLine());

            int residentNumber = getResidentCount(K, N);
            bufferedWriter.write(residentNumber + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getResidentCount(int K, int N) {
        // 초기화:
        int[][] dp = new int[K + 1][N + 1];

        // 기저 상태:
        for (int i = 1; i <= N; i++) {
            dp[0][i] = i;
        }

        // 점화식:
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        return dp[K][N];
    }
}
