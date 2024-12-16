package baekjoon.알고리즘분류.그리디알고리즘.복습문제;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] withdrawMoneyTime = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            withdrawMoneyTime[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int minWithdrawMoneyTime = calculateMinWithdrawalTimeSum(withdrawMoneyTime);
        bufferedWriter.write(String.valueOf(minWithdrawMoneyTime));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateMinWithdrawalTimeSum(int[] withdrawMoneyTime) {
        // 1. 선택 절차: 돈을 인출하는데 필요한 시간을 정렬한다.
        Arrays.sort(withdrawMoneyTime);

        // 2. 적절성 검사: 돈을 인출하는데 필요한 시간의 합을 계산한다.
        int minWithdrawMoneyTime = 0;

        // 외부 루프: i를 사용하여 배열의 각 인덱스를 순회한다.
        for (int i = 0; i < withdrawMoneyTime.length; i++) {
            int currentWithdrawMoneyTime = 0;
            // 내부 루프: 각 인덱스 i에 대해 0부터 i까지의 요소를 합산한다.
            for (int j = 0; j <= i; j++) {
                currentWithdrawMoneyTime += withdrawMoneyTime[j];
            }
            minWithdrawMoneyTime += currentWithdrawMoneyTime;
        }

        // 3. 해답 검사: 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하고 반환한다.
        return minWithdrawMoneyTime;
    }
}
