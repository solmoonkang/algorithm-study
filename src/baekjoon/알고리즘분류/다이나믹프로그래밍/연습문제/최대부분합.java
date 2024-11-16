package baekjoon.알고리즘분류.다이나믹프로그래밍.연습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 최대부분합 {

    /**
     * 문제 설명
     * 정수 배열이 주어졌을 때, 연속된 부분 배열의 최대 합을 구하세요.
     */

    /**
     * 입력
     * N = 9
     * array = -2 1 -3 4 -1 2 1 -5 4
     * <p>
     * N = 1
     * array = 1
     * <p>
     * 출력
     * 6
     * 1
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxSubarraySumTabulation = getMaxSubarraySumTabulation(numbers);

        bufferedWriter.write("Tabulation = " + maxSubarraySumTabulation + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getMaxSubarraySumTabulation(int[] numbers) {
        int[] dynamicArray = new int[numbers.length];
        dynamicArray[0] = numbers[0];

        int maxSubarraySum = dynamicArray[0];
        for (int i = 1; i < numbers.length; i++) {
            dynamicArray[i] = Math.max(numbers[i], dynamicArray[i - 1] + numbers[i]);
            maxSubarraySum = Math.max(maxSubarraySum, dynamicArray[i]);
        }

        return maxSubarraySum;
    }
}
