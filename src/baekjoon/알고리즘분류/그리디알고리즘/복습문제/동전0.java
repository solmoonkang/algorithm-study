package baekjoon.알고리즘분류.그리디알고리즘.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 동전0 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] valueOfCoins = new int[N];

        for (int i = 0; i < N; i++) {
            valueOfCoins[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int minCoinsAmount = minCoinsForAmountK(valueOfCoins, K);
        bufferedWriter.write(String.valueOf(minCoinsAmount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int minCoinsForAmountK(int[] valueOfCoins, int K) {
        int minCoinsValue = 0;

        // 1. 선택 절차: 동전 가치가 큰 동전부터 사용한다.
        for (int i = valueOfCoins.length - 1; i >= 0; i--) {
            int currentCoin = valueOfCoins[i];

            // 2. 적절성 검사: 현재 동전 가치가 K보다 작거나 같을 때
            if (K >= currentCoin) {
                // 예를 들어, K = 150, currentCoin = 50이라고 가정하자.
                // 현재 동전으로 만들 수 있는 최대 개수를 계산한다. -> minCoinsValue += 150 / 50 -> minCoinsValue += 3 (50원 동전 3개 사용)
                minCoinsValue += K / currentCoin;
                // K를 현재 동전의 가치를 사용한 후의 나머지로 업데이트한다. -> K %= 50 -> K = 0 (남은 금액이 0이므로 종료)
                // K를 currentCoin으로 나눈 나머지를 계산하여 남은 금액을 업데이트한다.
                K %= currentCoin;

                // 3. 해답 검사: K가 0이면, 남은 금액이 0이므로 해당 조건문을 종료한다.
                if (K == 0) break;
            }
        }

        return minCoinsValue;
    }
}
