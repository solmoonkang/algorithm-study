package 알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 평범한배낭 {

    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        int[][] backpackItems = new int[N][2];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            backpackItems[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            backpackItems[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxValue = getMaxValueOfBackpackItems(backpackItems);
        bufferedWriter.write(String.valueOf(maxValue));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxValueOfBackpackItems(int[][] backpackItems) {
        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            int W = backpackItems[i][0];
            int V = backpackItems[i][1];

            // dp[j]는 최대 K 무게를 가진 배낭에 담을 수 있는 물건의 최대 가치를 의미하는 배열이다. 여기서 j는 현재 고려하고 있는 배낭의 무게를 나타낸다.
            // 각 물건 i에 대해, 배낭의 무게를 j를 K부터 W[j]까지 거꾸로 탐색한다. 이는 해당 물건을 여러 번 사용할 수 있도록 하기 위해서이다.
            for (int j = K; j >= W; j--) dp[j] = Math.max(dp[j], dp[j - W] + V);
        }

        return dp[K];
    }
}
