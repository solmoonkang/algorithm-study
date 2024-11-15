package baekjoon.알고리즘분류.브루트포스;

import java.io.*;

public class 한수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int countHanNumber = 0;
        for (int i = 1; i <= N; i++) {
            if (isHanNumber(i)) countHanNumber++;
        }

        bufferedWriter.write(String.valueOf(countHanNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static boolean isHanNumber(int number) {
        if (number < 10) return true;

        int[] digits = String.valueOf(number).chars().map(c -> c - '0').toArray();

        int difference = digits[1] - digits[0];
        for (int i = 1; i < digits.length - 1; i++) {
            if (digits[i + 1] - digits[i] != difference) return false;
        }

        return true;
    }
}
