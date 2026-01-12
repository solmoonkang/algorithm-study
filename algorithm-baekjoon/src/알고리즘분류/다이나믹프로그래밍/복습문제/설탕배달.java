package 알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;
import java.util.Arrays;

public class 설탕배달 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int minSugarBags = calculateSugarBags(N);
        bufferedWriter.write(String.valueOf(minSugarBags));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateSugarBags(int number) {
        // dp[i]는 i KG을 만들기 위해 필요한 최소 봉지의 개수를 나타낸다.
        int[] dp = new int[number + 1];

        // 초기화: 최소 봉지 개수를 반환할 수 없을 경우 -1을 반환하기 위해 dp 배열을 -1로 초기화
        Arrays.fill(dp, -1);

        // 기저 상태
        dp[0] = 0;                      // 0 KG -> 반환할 것이 없으므로 0을 저장한다.
        if (number >= 3) dp[3] = 1;     // 3 KG -> 3KG 봉지를 반환할 수 있으므로 1을 저장한다.
        if (number >= 5) dp[5] = 1;     // 5 KG -> 5KG 봉지를 반환할 수 있으므로 1을 저장한다.

        for (int i = 1; i <= number; i++) {
            if (i >= 3 && dp[i - 3] != -1) dp[i] = (dp[i] == -1) ? dp[i - 3] + 1 : Math.min(dp[i], dp[i - 3] + 1);
            if (i >= 5 && dp[i - 5] != -1) dp[i] = (dp[i] == -1) ? dp[i - 5] + 1 : Math.min(dp[i], dp[i - 5] + 1);
        }

        return dp[number];
    }
}
