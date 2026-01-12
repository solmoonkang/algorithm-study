package 알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class 계단오르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] staircaseScore = new int[N];
        for (int i = 0; i < N; i++) {
            staircaseScore[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int maxStaircaseScore = getMaxStaircaseScore(staircaseScore);
        bufferedWriter.write(String.valueOf(maxStaircaseScore));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // TODO: 초기화와 점화식을 구현하는 방법에 대해서 더 고민해보자. 더 작게 보고 생각해야 할거 같다.
    public static int getMaxStaircaseScore(int[] staircaseScore) {
        int N = staircaseScore.length;

        if (N == 0) return 0;
        if (N == 1) return staircaseScore[0];
        if (N == 2) return staircaseScore[0] + staircaseScore[1];

        int[] dp = new int[N];
        dp[0] = staircaseScore[0];
        dp[1] = staircaseScore[0] + staircaseScore[1];

        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + staircaseScore[i]);
            if (i > 2) dp[i] = Math.max(dp[i], dp[i - 3] + staircaseScore[i - 1] + staircaseScore[i]);
        }

        return dp[N - 1];
    }
}
