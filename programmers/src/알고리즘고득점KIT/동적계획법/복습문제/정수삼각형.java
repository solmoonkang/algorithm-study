package 알고리즘고득점KIT.동적계획법.복습문제;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] triangel = new int[N][];

        for (int i = 0; i < N; i++) {
            triangel[i] = new int[i + 1];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j <= i; j++) {
                triangel[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int maxNumber = getMaxNumber(N, triangel);
        bufferedWriter.write(String.valueOf(maxNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }


    // 삼각형의 높이를 N이라고 할 때, 다이나믹 프로그래밍의 경우 점화식(반복문)을 사용하므로 O(N)이 걸리게 된다. 따라서 최대 500번의 연산을 효율적으로 처리할 수 있다.
    private static int getMaxNumber(int N, int[][] triangle) {

        // 루트부터 좌 우로 내려갈 수 있다.
        // 둘 중 큰 값을 선택한다.

        // i + 1 개수를 넘지 않는 선에서, 본인의 위치에서 [i + 1][j - 1]랑 [i + 1][j + 1]

        int[][] dp = new int[N][N];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < N; i++) {
            // 현재 층 i의 가장 왼쪽 원소 (0번째 원소)는 이전 층의 가장 왼쪽 원소와만 연결된다.
            dp[i][0] = dp[i - 1][0] + triangle[i][0];

            // 현재 층에서 1번째 원소부터 i - 1번째 원소까지 반복한다. 각 원소에 대한 최대 합을 계산한다.
            for (int j = 1; j < i; j++) {
                // 현재 층의 j번째 원소는 이전 층의 j - 1번째 원소 또는 j번째 원소에서 올 수 있다.
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }

            // 현재 층의 가장 오른쪽 원소는 이전 층의 가장 오른쪽 원소와만 연결된다. 즉, 현재 층의 i번째 원소는 이전 층의 i - 1번째 원소에서 올 수 있다.
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        int maxNumber = 0;
        for (int j = 0; j < N; j++) maxNumber = Math.max(maxNumber, dp[N - 1][j]);

        return maxNumber;
    }
}
