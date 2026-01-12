package 알고리즘분류.다이나믹프로그래밍.연습문제;

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
     * <p>
     * 출력
     * 5
     * 55
     */

    static int[] dynamic;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int fibonacciTabulation = getFibonacciTabulation(N);
        bufferedWriter.write("Tabulation = " + fibonacciTabulation + "\n");

        dynamic = new int[N + 1];
        int fibonacciMemoization = getFibonacciMemoization(N);
        bufferedWriter.write("Memoization = " + fibonacciMemoization);

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getFibonacciTabulation(int number) {
        int[] dynamicArray = new int[number + 1];
        dynamicArray[0] = 0;
        dynamicArray[1] = 1;

        for (int i = 2; i <= number; i++) {
            dynamicArray[i] = dynamicArray[i - 1] + dynamicArray[i - 2];
        }

        return dynamicArray[number];
    }

    public static int getFibonacciMemoization(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;

        if (dynamic[number] != 0) return dynamic[number];

        dynamic[number] = getFibonacciMemoization(number - 1) + getFibonacciMemoization(number - 2);
        return dynamic[number];
    }
}
