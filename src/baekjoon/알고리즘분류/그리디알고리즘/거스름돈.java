package baekjoon.알고리즘분류.그리디알고리즘;

import java.io.*;

public class 거스름돈 {

    private static final int THOUSAND_YEN = 1000;
    private static final int[] CHANGE_COINS = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int paymentAmount = Integer.parseInt(bufferedReader.readLine());
        int changeAmount = THOUSAND_YEN - paymentAmount;

        int minChangeCoin = 0;
        for (int currentChangeCoin : CHANGE_COINS) {
            while (changeAmount >= currentChangeCoin) {
                changeAmount -= currentChangeCoin;
                minChangeCoin++;
            }
        }

        bufferedWriter.write(String.valueOf(minChangeCoin));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
