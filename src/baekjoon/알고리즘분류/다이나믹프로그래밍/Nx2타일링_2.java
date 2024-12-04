package baekjoon.알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class Nx2타일링_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int fillRectangle = countWaysToFillRectangle(N);
        bufferedWriter.write(String.valueOf(fillRectangle));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int countWaysToFillRectangle(int number) {
        int[] dynamicArray = new int[number + 1];
        dynamicArray[1] = 1;
        if (number >= 2) dynamicArray[2] = 3;

        for (int i = 3; i <= number; i++) {
            dynamicArray[i] = (dynamicArray[i - 1] + dynamicArray[i - 2] * 2) % 10007;
        }

        return dynamicArray[number];
    }
}
