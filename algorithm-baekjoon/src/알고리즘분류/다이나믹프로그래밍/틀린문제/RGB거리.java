package 알고리즘분류.다이나믹프로그래밍.틀린문제;

import java.io.*;
import java.util.StringTokenizer;

public class RGB거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int housesNumber = Integer.parseInt(bufferedReader.readLine());

        int[][] RGB = new int[housesNumber][housesNumber];
        for (int i = 0; i < housesNumber; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            RGB[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            RGB[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            RGB[i][2] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int minCostPainting = getMinCostPaintingAllHouses(RGB);
        bufferedWriter.write(String.valueOf(minCostPainting));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMinCostPaintingAllHouses(int[][] RGB) {
        int N = RGB.length;
        int[][] dp = new int[N + 1][N + 1];

        dp[0][0] = RGB[0][0];
        dp[0][1] = RGB[0][1];
        dp[0][2] = RGB[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = RGB[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = RGB[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = RGB[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
    }
}
