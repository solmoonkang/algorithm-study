package 알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class 포도주시식 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] amountWine = new int[N];

        for (int i = 0; i < N; i++) {
            amountWine[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int maxWineAmount = getMaxWineAmount(amountWine);
        bufferedWriter.write(String.valueOf(maxWineAmount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMaxWineAmount(int[] amountWine) {
        if (amountWine.length == 0) return 0;
        if (amountWine.length == 1) return amountWine[0];
        if (amountWine.length == 2) return amountWine[0] + amountWine[1];

        /**
         * 기본 초기화
         *
         * dp[0]: 첫 번째 잔만 있는 경우, 마실 수 있는 양은 amountWine[0]
         * dp[1]: 첫 번째와 두 번째 잔이 있는 경우, 두 잔 모두 마실 수 있으므로 dp[1] = amountWine[0] + amountWine[1]
         * dp[2]:
         *  - 첫 번째 잔과 세 번째 잔을 마시는 경우: amountWine[0] + amountWine[2]
         *  - 두 번째 잔만 마시는 경우: amountWine[1]
         *  - 첫 번째 잔과 두 번째 잔을 마시는 경우: dp[1]
         */
        int[] dynamicArray = new int[amountWine.length];
        dynamicArray[0] = amountWine[0];
        dynamicArray[1] = amountWine[0] + amountWine[1];
        dynamicArray[2] = Math.max(amountWine[0] + amountWine[2], Math.max(amountWine[1], dynamicArray[1]));

        /**
         * 점화식
         *
         * dp[i - 1]: i번째 잔을 마시지 않는 경우, 최대량은 i - 1번째까지의 최대량
         * dp[i - 2] + amountWine[i]: i번째 잔을 마시고 i - 1번째 잔은 마시지 않는 경우, i - 2번쨰까지의 최대량에 i번째 잔의 양을 더함
         * dp[i - 3] + amountWine[i - 1] + amountWine[i]: i번째 잔과 i - 1번째 잔을 마시고 i - 2번쨰 잔은 마시지 않는 경우
         *  - i - 3번째까지의 최대량에 i - 1번째와 i번째 잔의 양을 더함
         */
        for (int i = 3; i < amountWine.length; i++) {
            dynamicArray[i] = Math.max(dynamicArray[i - 1],
                    Math.max(dynamicArray[i - 2] + amountWine[i],
                            dynamicArray[i - 3] + amountWine[i - 1] + amountWine[i])
            );
        }

        return dynamicArray[amountWine.length - 1];
    }
}
