package 알고리즘분류.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

public class 스티커 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());

            int[][] stickerScoreBoard = new int[2][N];

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) stickerScoreBoard[0][j] = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) stickerScoreBoard[1][j] = Integer.parseInt(stringTokenizer.nextToken());

            int maxStickerScoreSum = getMaxStickerScoreSum(N, stickerScoreBoard);
            bufferedWriter.write(maxStickerScoreSum + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxStickerScoreSum(int N, int[][] stickerScoreBoard) {
        int[][] dp = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + stickerScoreBoard[0][i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + stickerScoreBoard[1][i - 1]);
        }

        return Math.max(dp[N][0], dp[N][1]);
    }
}
