package 모든문제.level1;

import java.io.*;

public class 자릿수더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int digitSum = calculateDigitSum(N);
        bufferedWriter.write(String.valueOf(digitSum));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int calculateDigitSum(int N) {
        int sum = 0;

        while (N != 0) {
            sum += N % 10;
            N /= 10;
        }

        return sum;
    }
}
