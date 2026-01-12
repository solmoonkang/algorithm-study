package 알고리즘분류.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

public class 퇴사 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] T = new int[N];
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            T[i] = Integer.parseInt(stringTokenizer.nextToken());
            P[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxProfit = getMaxProfit(T, P);
        bufferedWriter.write(String.valueOf(maxProfit));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // TODO: 점화식 구현이 부족하여 최대 이익 값으로 0이 반환되고 있음.
    private static int getMaxProfit(int[] T, int[] P) {
        int N = T.length;
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int nextDay = i + T[i - 1];
            if (nextDay <= N + 1) dp[nextDay] = Math.max(dp[nextDay], dp[i] + P[i - 1]);
        }

        return dp[N + 1];
    }
}
