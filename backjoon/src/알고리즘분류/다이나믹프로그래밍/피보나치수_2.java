package 알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class 피보나치수_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        long fibonacciNumber = fibonacci(N);
        bufferedWriter.write(String.valueOf(fibonacciNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static long fibonacci(int number) {
        long[] dynamicArray = new long[number + 1];
        dynamicArray[0] = 0;
        dynamicArray[1] = 1;

        for (int i = 2; i <= number; i++) {
            dynamicArray[i] = dynamicArray[i - 1] + dynamicArray[i - 2];
        }

        return dynamicArray[number];
    }
}
