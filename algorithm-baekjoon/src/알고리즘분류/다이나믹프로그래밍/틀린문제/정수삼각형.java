package 알고리즘분류.다이나믹프로그래밍.틀린문제;

import java.io.*;

public class 정수삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int triangleSize = Integer.parseInt(bufferedReader.readLine());

        int[][] integerTriangle = new int[triangleSize][triangleSize];
        for (int i = 0; i < triangleSize; i++) {
            String[] elements = bufferedReader.readLine().split(" ");
            for (int j = 0; j < elements.length; j++) {
                integerTriangle[i][j] = Integer.parseInt(elements[j]);
            }
        }

        int maxSumPathNumber = getMaxSumPathNumber(integerTriangle);
        bufferedWriter.write(String.valueOf(maxSumPathNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxSumPathNumber(int[][] integerTriangle) {
        int N = integerTriangle.length;

        // DP 배열 정의: dp[i][j]는 i층의 j번째 숫자까지 도달했을 때의 최대 합을 저장한다. (i는 층의 인덱스 0부터 N-1까지, j는 해당 층의 인덱스 0부터 i까지)
        int[][] dp = new int[N][N];

        // 기저 조건 설정: 첫 번째 층의 경우, 그 숫자 하나만 존재한다.
        dp[0][0] = integerTriangle[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                // 첫 번째 열에서 현재 숫자는 위의 숫자(대각선 왼쪽)에서만 올 수 있다.
                if (j == 0) dp[i][j] = dp[i - 1][j] + integerTriangle[i][j];
                // 마지막 열에서 현재 숫자는 위의 숫자(대각선 오른쪽)에서만 올 수 있다.
                else if (j == i) dp[i][j] = dp[i - 1][j - 1] + integerTriangle[i][j];
                // 중간 열(그 외의 경우)에서 현재 숫자는 위 두 숫자(대각선 왼쪽과 오른쪽) 중에서 더 큰 경로 합을 선택할 수 있다.
                else dp[i][j] = integerTriangle[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }

        int maxSum = 0;
        // 마지막 층에서의 최대 합을 찾기 위해, dp[N - 1][j]의 최대 값을 구한다. 이는 마지막 층의 모든 숫자까지 도달할 수 있는 최대 경로의 합을 의미한다.
        for (int j = 0; j < N; j++) maxSum = Math.max(maxSum, dp[N - 1][j]);
        return maxSum;
    }
}
