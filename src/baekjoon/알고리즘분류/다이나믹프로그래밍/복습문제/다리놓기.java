package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 다리놓기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            int bridgeCombination = findBridgeBuildingPossibilities(N, M);
            bufferedWriter.write(bridgeCombination + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int findBridgeBuildingPossibilities(int N, int M) {
        // 초기화
        int[][] dp = new int[N + 1][M + 1];

        // 기저 상태: 0개의 위치에서 i개의 다리를 놓는 경우를 의미한다.
        // 다리가 필요 없다면, 다리를 놓는 방법은 하나뿐이다. 즉, 아무것도 놓지 않는 방법이 존재하기 때문에 모든 i에 대해 1로 초기화한다.
        for (int i = 0; i <= M; i++) dp[0][i] = 1;

        // 점화식
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // 다리를 놓는 경우: 현재 위치 i에 다리를 놓는 경우로, 이전 위치에 j-1개의 다리를 놓아야 한다.
                // 다리를 놓지 않는 경우: 현재 위치 i에 다리를 놓지 않는 경우로, 현재 위치를 무시하고 이전 위치에서 j개의 다리를 놓아야 한다.
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
            }
        }

        return dp[N][M];
    }
}
