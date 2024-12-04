package baekjoon.알고리즘분류.다이나믹프로그래밍.복습문제;

import java.io.*;

public class 일로만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int minimumCount = findMinimumOperations(N);
        bufferedWriter.write(String.valueOf(minimumCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int findMinimumOperations(int N) {
        int[] dynamicArray = new int[N + 1];
        dynamicArray[1] = 0;

        for (int i = 2; i <= N; i++) {
            dynamicArray[i] = dynamicArray[i - 1] + 1;
            if (i % 2 == 0) dynamicArray[i] = Math.min(dynamicArray[i], dynamicArray[i / 2] + 1);
            if (i % 3 == 0) dynamicArray[i] = Math.min(dynamicArray[i], dynamicArray[i / 3] + 1);
        }

        return dynamicArray[N];
    }
}
