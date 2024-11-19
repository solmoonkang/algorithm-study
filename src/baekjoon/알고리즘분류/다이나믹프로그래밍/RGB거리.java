package baekjoon.알고리즘분류.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

public class RGB거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] costs = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            costs[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            costs[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            costs[i][2] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int minPaintCost = getMinPaintCost(costs);
        bufferedWriter.write(String.valueOf(minPaintCost));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // TODO: 초기화, 점화식 부분 구현에 어려움이 있다.
    public static int getMinPaintCost(int[][] costs) {
        int N = costs.length;

        int[][] dp = new int[N + 1][N + 1];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
    }
}
