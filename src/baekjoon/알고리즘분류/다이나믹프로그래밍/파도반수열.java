package baekjoon.알고리즘분류.다이나믹프로그래밍;

import java.io.*;

public class 파도반수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            long padoBan = calculatePadoBan(N);
            bufferedWriter.write(padoBan + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static long calculatePadoBan(int N) {
        long[] P = new long[101];

        P[1] = 1;
        P[2] = 1;
        P[3] = 1;

        for (int i = 4; i <= 100; i++) {
            P[i] = P[i - 2] + P[i - 3];
        }

        return P[N];
    }
}
