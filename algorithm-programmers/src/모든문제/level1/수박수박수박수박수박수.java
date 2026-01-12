package 모든문제.level1;

import java.io.*;

public class 수박수박수박수박수박수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        String pattern = preservePattern(N);
        bufferedWriter.write(pattern);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String preservePattern(int N) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) stringBuilder.append("박");
            else stringBuilder.append("수");
        }

        return stringBuilder.toString();
    }

    private static String anotherSolution(int N) {
        return new String(new char[N / 2 + 1]).replace("\0", "수박").substring(0, N);
    }
}
