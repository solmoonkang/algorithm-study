package baekjoon.알고리즘분류.다이나믹프로그래밍.연습문제;

import java.io.*;

public class 피보나치수열 {

    /**
     * 문제 설명
     * n번째 피보나치 수를 구하는 함수를 작성하세요. 피보나치 수열은 다음과 같이 정의됩니다:
     * F(0) = 0, F(1) = 1, F(N) = F(N - 1) + F(N - 2) (N >= 2)
     */

    /**
     * 입력
     * 5
     * 10
     *
     * 출력
     * 5
     * 55
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int fibonacci = getFibonacciTabulated(N);

        bufferedWriter.write(fibonacci + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getFibonacciTabulated(int number) {
        int[] dynamicArray = new int[number + 1];
        dynamicArray[0] = 0;
        dynamicArray[1] = 1;

        for (int i = 2; i <= number; i++) {
            dynamicArray[i] = dynamicArray[i - 1] + dynamicArray[i - 2];
        }

        return dynamicArray[number];
    }
}
