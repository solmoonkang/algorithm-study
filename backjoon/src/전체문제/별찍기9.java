package 전체문제;

import java.io.*;

public class 별찍기9 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        for (int i = 1; i <= N; i++) {
            bufferedWriter.write(" ".repeat(i - 1));
            bufferedWriter.write("*".repeat(2 * (N - i) + 1));
            bufferedWriter.newLine();
        }

        for (int i = 1; i <= N - 1; i++) {
            bufferedWriter.write(" ".repeat(N - 1 - i));
            bufferedWriter.write("*".repeat(2 * i + 1));
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
