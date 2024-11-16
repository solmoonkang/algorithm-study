package baekjoon.알고리즘분류.다이나믹프로그래밍.연습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 동전조합수 {

    /**
     * 문제 설명
     * 주어진 동전의 종류와 목표 금액이 있을 때, 목표 금액을 만들기 위한 동전의 조합 수를 구하세요.
     */

    /**
     * 입력
     * N = 3
     * coins = 1 2 5
     * amount = 5
     * <p>
     * N = 1
     * coins = 2
     * amount = 3
     * <p>
     * 출력
     * 4
     * 0
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int amount = Integer.parseInt(bufferedReader.readLine());

        int countWay = getCoinCombinationCountTabulation(coins, amount);
        bufferedWriter.write("Tabulation = " + countWay + "\n");

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getCoinCombinationCountTabulation(int[] coins, int amount) {
        int[] dynamicArray = new int[amount + 1];
        dynamicArray[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dynamicArray[j] += dynamicArray[j - coin];
            }
        }

        return dynamicArray[amount];
    }
}
