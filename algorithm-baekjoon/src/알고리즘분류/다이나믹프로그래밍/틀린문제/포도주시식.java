package 알고리즘분류.다이나믹프로그래밍.틀린문제;

import java.io.*;

public class 포도주시식 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] wineAmounts = new int[N];
        for (int i = 0; i < N; i++) wineAmounts[i] = Integer.parseInt(bufferedReader.readLine());

        int maxWineAmount = getMaxWineAmountCanDrink(N, wineAmounts);
        bufferedWriter.write(String.valueOf(maxWineAmount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxWineAmountCanDrink(int N, int[] wineAmounts) {
        // 포도주 잔이 1개일 경우, 무조건 그 잔을 마시면 된다.
        if (N == 1) return wineAmounts[0];
        // 포도주 잔이 2개일 경우, 둘 다 마시는 것이 최대값이 된다.
        if (N == 2) return wineAmounts[0] + wineAmounts[1];

        // 최대로 마실 수 있는 포도주의 양을 저장한다.
        int[] dp = new int[N];

        // 현재 잔 i번째 잔을 마시지 않는 경우
        // 현재 잔 i번째 잔을 마시는 경우, 1번 전 i - 1번째 잔도 마시는 경우
        // 현재 잔 i번째 잔을 마시는 경우, 1번 전 i - 1번째 잔도 마시는 경우, 2번 전 i - 2번째 잔은 마시지 않는 경우

        // 첫 번째 잔만 마시는 경우
        dp[0] = wineAmounts[0];
        // 첫 번째 + 두 번째 잔을 마시는 경우
        dp[1] = wineAmounts[0] + wineAmounts[1];
        // 첫 번째 + 두 번째, 첫 번째 + 세 번째, 두 번째 + 세 번째 잔을 마시는 경우 중 최대값을 선택
        dp[2] = Math.max(dp[1],
                Math.max(wineAmounts[0] + wineAmounts[2], wineAmounts[1] + wineAmounts[2]));

        int maxWineAmount = dp[0];

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + wineAmounts[i], dp[i - 3] + wineAmounts[i - 1] + wineAmounts[i]));
        }

        return maxWineAmount;
    }
}
