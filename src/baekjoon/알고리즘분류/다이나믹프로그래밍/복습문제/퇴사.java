package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 퇴사 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        int[][] consultingSchedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            consultingSchedule[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            consultingSchedule[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxConsultationProfit = calculateMaxProfitFromConsultations(consultingSchedule);
        bufferedWriter.write(String.valueOf(maxConsultationProfit));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateMaxProfitFromConsultations(int[][] consultingSchedule) {
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            int duration = consultingSchedule[i][0];
            int profit = consultingSchedule[i][1];

            // 현재 상담을 시작하는 날짜 i에 상담 기간 duration을 더했을 때, 총 날짜가 N을 초과하지 않는 경우 상담을 진행할 수 있다.
            if (i + duration <= N)
                // i + duration일째까지의 최대 수익과 현재 상담을 선택했을 때의 수익을 비교하여 더 큰 값을 dp[i + duration]에 저장한다.
                // 즉, 현재 상담을 선택하는 것과 선택하지 않는 것 중에서 최대 수익을 선택하는 것이다.
                dp[i + duration] = Math.max(dp[i + duration], dp[i] + profit);
        }

        // i일째까지의 최대 수익이 이전 날과 동일하거나 더 큰지 확인한다. 이로 인해 만약 상담을 선택하지 않았다면 이전 날의 최대 수익을 반영한다.
        // 즉, 해당 루프는 각 날에 대해 상담을 선택하지 않았다면 이전 날의 최대 수익을 반영한다.
        for (int i = 1; i <= N; i++) dp[i] = Math.max(dp[i], dp[i - 1]);

        // 주어진 N일 동안 가능한 모든 상담을 고려했을 때 얻을 수 있는 최대 수익을 반환한다.
        return dp[N];
    }
}
