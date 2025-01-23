package baekjoon.알고리즘분류.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

public class 구간합구하기_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] board = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        generatePrefixSum(dp, board, N);

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int X1 = Integer.parseInt(stringTokenizer.nextToken()), Y1 = Integer.parseInt(stringTokenizer.nextToken());
            int X2 = Integer.parseInt(stringTokenizer.nextToken()), Y2 = Integer.parseInt(stringTokenizer.nextToken());

            int maxSumFromPointToPoint = getSumFromPointToPoint(dp, X1, Y1, X2, Y2);
            bufferedWriter.write(maxSumFromPointToPoint + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generatePrefixSum(int[][] dp, int[][] board, int N) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = board[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
    }

    private static int getSumFromPointToPoint(int[][] dp, int X1, int Y1, int X2, int Y2) {
        return dp[X2][Y2] - dp[X1 - 1][Y2] - dp[X2][Y1 - 1] + dp[X1 - 1][Y1 - 1];
    }
}
