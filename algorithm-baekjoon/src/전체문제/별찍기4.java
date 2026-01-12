package 전체문제;

import java.io.*;

public class 별찍기4 {

    private static final String STAR = "*";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        for (int i = N; i >= 1; i--) {
            bufferedWriter.write(" ".repeat(N - i));
            bufferedWriter.write(STAR.repeat(i));
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
