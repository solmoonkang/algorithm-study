package 알고리즘분류.구현;

import java.io.*;

public class 피보나치수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int fibonacciNumber = findFibonacciNumber(N);
        bufferedWriter.write(String.valueOf(fibonacciNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int findFibonacciNumber(int number) {
        int[] dynamicArray = new int[46];

        dynamicArray[0] = 0;
        dynamicArray[1] = 1;
        dynamicArray[2] = 1;

        for (int i = 3; i <= number; i++) {
            dynamicArray[i] = dynamicArray[i - 1] + dynamicArray[i - 2];
        }

        return dynamicArray[number];
    }
}
