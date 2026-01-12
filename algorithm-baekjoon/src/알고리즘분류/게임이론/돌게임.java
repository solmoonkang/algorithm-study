package 알고리즘분류.게임이론;

import java.io.*;

public class 돌게임 {

    private static final int ONE_STONE = 1;
    private static final int THREE_STONE = 3;
    private static final String SANGGEUN_WINS_GAME = "SK";
    private static final String CHANGYOUNG_WINS_GAME = "CY";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        bufferedWriter.write(whoWinsPlayingGame(N) ? SANGGEUN_WINS_GAME : CHANGYOUNG_WINS_GAME);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean whoWinsPlayingGame(int N) {
        boolean[] dp = new boolean[N + 1];

        dp[0] = false;
        if (N >= 1) dp[1] = true;
        if (N >= 2) dp[2] = true;
        if (N >= 3) dp[3] = true;

        // 상근이가 i개의 돌에서 1개를 가져가면, 남은 돌의 개수는 i - 1개가 되며 dp[i - 1] = false라면 상근이는 이길 수 있다.
        // 마찬가지로 3개를 가져가면, 남은 돌의 개수는 i - 3개가 되며 dp[i - 3] = false라면 상근이는 이길 수 있다.
        for (int i = 4; i <= N; i++) dp[i] = !dp[i - ONE_STONE] || (i >= THREE_STONE && !dp[i - THREE_STONE]);

        return dp[N];
    }
}
