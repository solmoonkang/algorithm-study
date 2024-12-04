package baekjoon.알고리즘분류.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

public class 연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxSubarraySum = findMaxSubarraySum(numbers);
        bufferedWriter.write(String.valueOf(maxSubarraySum));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int findMaxSubarraySum(int[] numbers) {
        int[] dynamicArray = new int[numbers.length];
        dynamicArray[0] = numbers[0];

        int maxSubarraySum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            dynamicArray[i] = Math.max(numbers[i], dynamicArray[i - 1] + numbers[i]);
            maxSubarraySum = Math.max(maxSubarraySum, dynamicArray[i]);
        }

        return maxSubarraySum;
    }
}
