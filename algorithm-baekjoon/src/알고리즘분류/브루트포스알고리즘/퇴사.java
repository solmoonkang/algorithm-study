package 알고리즘분류.브루트포스알고리즘;

import java.io.*;
import java.util.StringTokenizer;

public class 퇴사 {

    private static int N;
    private static int[] T, P;
    private static int profit = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            T[i] = Integer.parseInt(stringTokenizer.nextToken());
            P[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        findMaxProfit(1, 0);

        bufferedWriter.write(String.valueOf(profit));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void findMaxProfit(int day, int currentProfit) {
        // 모든 상담을 다 확인한 경우
        if (day > N) {
            // 현재 이익과 최대 이익을 비교
            if (currentProfit > profit) profit = currentProfit;
            return;
        }

        // 1. 현재 상담을 선택하지 않는 경우
        findMaxProfit(day + 1, currentProfit);

        // 2. 현재 상담을 선택하는 경우
        // 상담을 선택할 수 있는 경우
        if (day + T[day] - 1 <= N) findMaxProfit(day + T[day], currentProfit + P[day]);
    }
}
