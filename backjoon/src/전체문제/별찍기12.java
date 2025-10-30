package 전체문제;

import java.io.*;

public class 별찍기12 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        for (int i = 1; i <= N; i++) {
            bufferedWriter.write(" ".repeat(N - i));
            bufferedWriter.write("*".repeat(i));
            bufferedWriter.newLine();
        }

        for (int i = N - 1; i > 0; i--) {
            bufferedWriter.write(" ".repeat(N - i));
            bufferedWriter.write("*".repeat(i));
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
