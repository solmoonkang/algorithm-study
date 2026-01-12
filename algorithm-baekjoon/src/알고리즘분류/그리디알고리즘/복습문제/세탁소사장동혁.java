package 알고리즘분류.그리디알고리즘.복습문제;

import java.io.*;

public class 세탁소사장동혁 {

    private static final StringBuilder stringBuilder = new StringBuilder();
    // 1. 선택 절차: 25, 10, 5, 1의 동전으로 잔돈을 나누어 저장한다.
    private static final int[] COIN_QUANTITIES = {25, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int change = Integer.parseInt(bufferedReader.readLine());
            displayCoinQuantities(change);
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void displayCoinQuantities(int change) {
        // 1. 선택 절차: 루프에서 각 동전의 개수를 계산한다.
        for (int coin : COIN_QUANTITIES) {
            // 3. 해답 검사: 동전의 개수를 구하고 이를 StringBuilder에 추가하여 반환한다.
            stringBuilder.append(change / coin).append(" ");
            // 2. 적절성 검사: 각 동전의 개수를 계산할 때 잔돈의 값이 0 이상인지 확인한다.
            change %= coin;
        }

        stringBuilder.append("\n");
    }
}
