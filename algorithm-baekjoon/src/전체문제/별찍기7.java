package 전체문제;

import java.io.*;

public class 별찍기7 {

    private static final String STAR = "*";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        for (int i = 1; i <= N; i++) {
            bufferedWriter.write(" ".repeat(N - i));
            bufferedWriter.write(STAR.repeat(2 * i - 1));
            bufferedWriter.newLine();
        }

        for (int i = N - 1; i >= 1; i--) {
            bufferedWriter.write(" ".repeat(N - i));
            bufferedWriter.write(STAR.repeat(2 * i - 1));
            bufferedWriter.newLine();
        }


        // 하나의 루프로 현재 줄이 N을 기준으로 몇 번째 줄인지 알 수 있도록 k를 사용해 별을 출력한다.
        for (int i = 1; i <= 2 * N - 1; i++) {
            int k = (i <= N) ? i : 2 * N - i;
            bufferedWriter.write(" ".repeat(N - k));
            bufferedWriter.write(STAR.repeat(2 * k - 1));
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
