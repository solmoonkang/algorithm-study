package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 정수삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] triangle = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int maxPathSum = findMaxPathSum(triangle);
        bufferedWriter.write(String.valueOf(maxPathSum));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int findMaxPathSum(int[][] triangle) {
        // 초기화
        int N = triangle.length;
        int[][] dp = new int[N][N];

        // 기저 상태
        dp[0][0] = triangle[0][0];

        // 점화식
        for (int i = 1; i < N; i++) {
            // 삼각형의 각 층 i에는 i + 1개의 수가 있으므로, i + 1까지 순회한다.
            for (int j = 0; j <= i; j++) {
                // 가장 왼쪽에 있는 숫자를 선택하는 경우로, 이전 층의 j 인덱스 즉, dp[i-1][0]만 선택할 수 있다.
                if (j == 0) dp[i][j] = dp[i - 1][j] + triangle[i][j];
                // 가장 오른쪽에 있는 숫자를 선택하는 경우로, 이전 층의 j-1 인덱스 즉, dp[i-1][j-1]만 선택할 수 있다.
                else if (j == i) dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                // 왼쪽 대각선과 오른쪽 대각선 중 더 큰 값을 선택하는 경우로, 두 경로 중 더 큰 값을 선택하여 현재 위치의 값을 더한다.
                else dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        // 가장 마지막 층의 모든 값 중에서 최대값을 찾는 과정으로, dp[N-1][i]는 마지막 층의 i번째 위치에서 가능한 최대 합을 의미한다.
        int maxPathSum = 0;
        for (int i = 0; i < N; i++) maxPathSum = Math.max(maxPathSum, dp[N - 1][i]);

        return maxPathSum;
    }
}
