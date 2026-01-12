package 알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class 피보나치함수 {

    private static final int MAX_N = 40;
    private static int[][] counts = new int[MAX_N + 1][2];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        calculateFibonacciCounts();

        int T = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(counts[N][0]).append(" ").append(counts[N][1]).append("\n");
        }

        bufferedWriter.write(stringBuilder.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static void calculateFibonacciCounts() {
        counts[0][0] = 1;
        counts[0][1] = 0;
        counts[1][0] = 0;
        counts[1][1] = 1;

        for (int i = 2; i <= MAX_N; i++) {
            counts[i][0] = counts[i - 1][0] + counts[i - 2][0];
            counts[i][1] = counts[i - 1][1] + counts[i - 2][1];
        }
    }
}
