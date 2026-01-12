package 알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class 쉬운계단수 {

    private static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int countStairNumber = countStairNumbers(N);
        bufferedWriter.write(String.valueOf(countStairNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int countStairNumbers(int number) {
        /**
         * 2차원 배열로 선언한 이유
         *
         * 계단 수의 길이와 마지막 자리 숫자에 따라 계단 수의 개수를 구분할 수 있기 때문
         *  - 첫 번째 차원: 숫자의 길이, dp[3][4] = 길이가 3이고 마지막 숫자가 4인 계단 수의 개수를 의미
         *  - 두 번째 차원: 마지막 자리 숫자, 각 자리의 숫자는 0부터 9까지 가능하여 10개의 인덱스를 갖음
         */
        int[][] dynamicArray = new int[number + 1][10];

        /**
         * 초기화
         *
         * 길이가 1인 계단 수는 1부터 9까지의 숫자만 가능하므로, 길이가 1일 때 숫자에 대해 1개의 경우가 존재
         * 길이가 1인 계단 수는 1, 2, 3, ..., 9로, 총 9개의 계단 수가 있기 때문에 dp[1][i]에 1을 할당하여 길이 1의 경우를 초기화
         */
        for (int i = 1; i < 10; i++) {
            dynamicArray[1][i] = 1;
        }

        /**
         * 점화식
         *
         * 점화식은 계단 수의 정의에서 비롯하여 계단 수는 인접한 자리의 차이가 1이기 때문에, 마지막 자리 숫자에 따라 이전 자리 숫자를 결정
         *  - if (j > 0): 마지막 숫자가 j일 때, 이전 숫자는 j - 1일 수 있음. 즉, 마지막 자리에서 1이 감소한 경우
         *  - if (j < 9): 마지막 숫자가 j일 때, 이전 숫자는 j + 1일 수 있음. 즉, 마지막 자리에서 1이 증가한 경우
         * 각 자리에서 가능한 경우를 고려하여 dp[i][j]를 업데이트
         * 마지막으로 dp[i][j] %= MOD를 통해 나눈 나머지를 저장하여 오버플로우를 방지
         */
        for (int i = 2; i <= number; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > 0) dynamicArray[i][j] += dynamicArray[i - 1][j - 1];
                if (j < 9) dynamicArray[i][j] += dynamicArray[i - 1][j + 1];
                dynamicArray[i][j] %= MOD;
            }
        }

        /**
         * 길이가 N인 모든 계단 수를 합산하여 최종 결과를 계산
         *
         *  - for (int i = 0; i < 10; i++): 마지막 자리 숫자가 0부터 9까지 가능한 모든 경우를 고려
         *  - stairNumber = (stairNumber + dynamicArray[number][i]) % MOD: 각 마지막 자리 숫자에 대해 해당하는 계단 수의 개수를 합산하고, 최종 결과를 MOD로 나눈 나머지를 계산
         */
        int stairNumber = 0;
        for (int i = 0; i < 10; i++) {
            stairNumber = (stairNumber + dynamicArray[number][i]) % MOD;
        }

        return stairNumber;
    }
}
