package baekjoon.단계문제.심화;

import java.io.*;

public class 별찍기_7 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        // 위쪽 삼각형: 총 N개의 줄로 이루어져 별의 개수가 홀수로 증가하며, 공백의 개수는 N - i개이다.
        // 아래쪽 삼각형: 총 N - 1개의 줄로 이루어져 별의 개수가 홀수로 감소하며, 공백의 개수는 i개이다.

        for (int p = 1; p <= N; p++) {
            for (int space = 0; space < N - p; space++) {
                bufferedWriter.write(" ");
            }

            for (int star = 0; star < 2 * p - 1; star++) {
                bufferedWriter.write("*");
            }
            bufferedWriter.newLine();
        }

        for (int n = N - 1; n > 0; n--) {
            for (int space = 0; space < N - n; space++) {
                bufferedWriter.write(" ");
            }

            for (int star = 0; star < 2 * n - 1; star++) {
                bufferedWriter.write("*");
            }
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
