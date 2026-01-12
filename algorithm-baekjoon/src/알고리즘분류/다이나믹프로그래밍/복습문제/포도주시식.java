package 알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;

public class 포도주시식 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        int[] wineAmount = new int[N];
        for (int i = 0; i < N; i++) wineAmount[i] = Integer.parseInt(bufferedReader.readLine());

        int maxWineAmount = drinkMaxWineAmount(wineAmount);
        bufferedWriter.write(String.valueOf(maxWineAmount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int drinkMaxWineAmount(int[] wineAmount) {
        // 초기화: 입력받은 N은 1과 10,000 사이에 위치한다.
        int[] dp = new int[N + 1];

        // 기저 상태: 연속 3잔을 마실 수 없으므로, 각 와인의 양에 따른 최대 값을 구해야 한다.
        dp[0] = wineAmount[0];
        dp[1] = wineAmount[0] + wineAmount[1];
        dp[2] = Math.max(wineAmount[0] + wineAmount[1],
                Math.max(wineAmount[0] + wineAmount[2], wineAmount[1] + wineAmount[2]));

        // 잔을 마시지 않는 경우: i번째 잔을 마시지 않고, 이전까지의 최적의 선택을 그대로 가져오는 경우이다. 즉, i번째 잔을 마시지 않으면, 최대 포도주 양은 i-1번째 잔까지의 최대 포도주 양과 같다.
        // i번째 잔을 마시는 경우:
            // 첫 번째 경우: i번째 잔을 마시고, i-1번째 잔은 마시지 않는 경우이다. 이 경우, i-2번째 잔까지의 최대 포도주 양에 i번째 잔의 포도주 양을 더하는 것이다. 즉, i-2까지의 결과에 i번째 잔을 추가하는 것이다.
            // 두 번쨰 경우: i번째와 i-1번째 잔을 마시고, i-2번째 잔은 마시지 않는 경우이다. 이 경우, i-3번째 잔까지의 최대 포도주 양에 i번째 잔과 i-1번째 잔의 포도주 양을 더하는 것이다. 즉, i-3까지의 결과에 i-1번째와 i번째 잔을 추가하는 것이다.
        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + wineAmount[i], dp[i - 3] + wineAmount[i - 1] + wineAmount[i]));
        }

        return dp[N - 1];
    }
}
