package baekjoon.알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.StringTokenizer;

public class A에서B로 {

    private static final int IMPOSSIBLE_TRANSFORMATION = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        int minOperations = calculateMinOperationsToTransform(A, B);
        bufferedWriter.write(String.valueOf(minOperations));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateMinOperationsToTransform(int startNumber, int targetNumber) {
        int operationCount = 0;

        while (targetNumber > startNumber) {
            if (targetNumber % 2 == 0) {
                targetNumber /= 2;
            } else if (targetNumber % 10 == 1) {
                targetNumber /= 10;
            } else {
                break;
            }
            operationCount++;
        }

        return targetNumber < startNumber ? IMPOSSIBLE_TRANSFORMATION : operationCount + 1;
    }
}
