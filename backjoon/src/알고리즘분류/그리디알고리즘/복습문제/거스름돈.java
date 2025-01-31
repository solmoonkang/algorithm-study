package 알고리즘분류.그리디알고리즘.복습문제;

import java.io.*;

public class 거스름돈 {

    private static final int ONE_THOUSAND_YEN = 1000;
    // 1. 선택 절차: 500, 100, 50, 10, 5, 1의 동전으로 잔돈을 나누어 저장한다.
    private static final int[] COIN_QUANTITIES = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int payment = Integer.parseInt(bufferedReader.readLine());

        int change = calculateChangeCoins(payment);
        bufferedWriter.write(String.valueOf(change));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateChangeCoins(int payment) {
        int change = ONE_THOUSAND_YEN - payment;

        int minCoinChanges = 0;

        // 1. 선택 절차: 루프에서 각 동전의 개수를 계산한다.
        for (int coin : COIN_QUANTITIES) {
            // 2. 적절성 검사: 각 동전의 개수를 계산할 때 잔돈의 값이 0 이상인지 확인한다.
            minCoinChanges += change / coin;
            change %= coin;
        }

        // 3. 해답 검사: 각 동전의 개수를 구하고 이를 반환한다.
        return minCoinChanges;
    }
}
