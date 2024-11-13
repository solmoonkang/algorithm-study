package baekjoon.단계문제.반복문;

import java.io.*;

public class A더하기B_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = bufferedReader.readLine();
            String[] testCases = input.split(" ");

            int A = Integer.parseInt(testCases[0]);
            int B = Integer.parseInt(testCases[1]);

            if (A == 0 && B == 0) break;

            int sum = A + B;
            bufferedWriter.write(String.valueOf(sum));
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
