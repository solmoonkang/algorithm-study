package 알고리즘분류.다이나믹프로그래밍.연습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 영과일배낭문제 {

    /**
     * 문제 설명
     * 각 물품의 무게와 가치를 알고 있을 때, 주어진 무게 제한 내에서 최대 가치를 얻는 방법을 구하세요.
     * N: 물품의 개수
     * weights: 각 물품의 무게를 나타내는 배열
     * values: 각 물품의 가치를 나타내는 배열
     * capacity: 배낭에 담을 수 있는 최대 무게
     */

    /**
     * 입력
     * N = 3
     * weights = 1 2 3
     * values = 10 15 40
     * capacity = 6
     * <p>
     * N = 4
     * weights = 2, 3, 4, 5
     * values = 3, 4, 5, 6
     * capacity = 5
     * <p>
     * 출력
     * 65
     * 7
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] weights = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int capacity = Integer.parseInt(bufferedReader.readLine());
        int maxValue = getMaxValueInKnapsack(weights, values, capacity);

        bufferedWriter.write(String.valueOf(maxValue));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getMaxValueInKnapsack(int[] weights, int[] values, int capacity) {
        int N = weights.length;
        int[][] dp = new int[N + 1][capacity + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                else dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[N][capacity];
    }
}
