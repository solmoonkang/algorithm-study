package 알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class 영일타일 {

    private static final int MOD = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int tileAmount = generateBinaryTile(N);
        bufferedWriter.write(String.valueOf(tileAmount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int generateBinaryTile(int tileAmount) {
        if (tileAmount == 0) return 0;

        int[] dp = new int[tileAmount + 1];

        dp[1] = 1;
        if (tileAmount >= 2) dp[2] = 2;

        for (int i = 3; i <= tileAmount; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;

        return dp[tileAmount];
    }
}
