package 알고리즘분류.그리디알고리즘;

import java.io.*;

public class 거스름돈_편의점 {

    private static final int UNABLE_TO_GIVE_CHANGE = -1;

    private static final int TWO_COIN = 2;
    private static final int FIVE_COIN = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int minCoinsNumber = getMinCoinsNumber(N);
        bufferedWriter.write(String.valueOf(minCoinsNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMinCoinsNumber(int changeAmount) {
        int totalCoinAmount = 0;

        totalCoinAmount += changeAmount / FIVE_COIN;
        changeAmount %= FIVE_COIN;

        while (changeAmount > 0) {
            if (changeAmount % TWO_COIN == 0) {
                totalCoinAmount += changeAmount / TWO_COIN;
                return totalCoinAmount;
            }

            totalCoinAmount--;
            changeAmount += FIVE_COIN;
        }

        return UNABLE_TO_GIVE_CHANGE;
    }
}
