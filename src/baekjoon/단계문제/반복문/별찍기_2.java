package baekjoon.단계문제.반복문;

import java.io.*;

public class 별찍기_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) {
                bufferedWriter.write(" ");
            }

            for (int j = 0; j < i; j++) {
                bufferedWriter.write("*");
            }
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
