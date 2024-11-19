package baekjoon.알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class 부녀회장이될테야 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(bufferedReader.readLine());
            int N = Integer.parseInt(bufferedReader.readLine());
            int residentsCount = getResidentsCount(K, N);
            bufferedWriter.write(residentsCount + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getResidentsCount(int floor, int room) {
        int[][] dp = new int[floor + 1][room + 1];

        for (int j = 1; j <= room; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= floor; i++) {
            for (int j = 1; j <= room; j++) {
                dp[i][j] += dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[floor][room];
    }
}
