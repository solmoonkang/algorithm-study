package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class RGB거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        // 2D 배열의 크기는 Nx3으로 초기화, 각 집에 대해 R G B의 비용을 저장한다.
        int[][] houses = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int minCost = minCostToPaintHouses(houses);
        bufferedWriter.write(String.valueOf(minCost));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int minCostToPaintHouses(int[][] houses) {
        // 초기화:
        int N = houses.length;
        int[][] dp = new int[N][3];

        // 기저 상태:
        dp[0][0] = houses[0][0];    // 1번 집을 R로 칠하는 비용
        dp[0][1] = houses[0][1];    // 1번 집을 G로 칠하는 비용
        dp[0][2] = houses[0][2];    // 1번 집을 B로 칠하는 비용

        // 점화식:
        for (int i = 1; i < N; i++) {
            dp[i][0] = houses[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);     // 1번 집을 R로 칠할 때
            dp[i][1] = houses[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);     // 1번 집을 G로 칠할 때
            dp[i][2] = houses[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);     // 1번 집을 B로 칠할 때
        }

        return Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));    // 집의 색에 따른 최소 비용 중 최솟값을 반환
    }
}
