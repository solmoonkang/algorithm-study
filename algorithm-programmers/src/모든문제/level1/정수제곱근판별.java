package 모든문제.level1;

import java.io.*;

public class 정수제곱근판별 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long number = Long.parseLong(bufferedReader.readLine());

        long nextSquare = findNextSquare(number);
        bufferedWriter.write(String.valueOf(nextSquare));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static long findNextSquare(long number) {
        long X = (long) Math.sqrt(number);
        if (X * X == number) return (X + 1) * (X + 1);
        return -1;
    }
}
