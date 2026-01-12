package 알고리즘분류.브루트포스알고리즘;

import java.io.*;

public class N_Queen {

    private static int N;
    private static int count = 0;
    private static boolean[] cols;
    private static boolean[] diag1;
    private static boolean[] diag2;

    // TODO: 백트래킹 개념에 대해 더 공부하고 다시 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        cols = new boolean[N];
        diag1 = new boolean[2 * N];
        diag2 = new boolean[2 * N];

        placeQueen(0);

        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static void placeQueen(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!cols[col] && !diag1[row - col + N] && !diag2[row + col]) {
                cols[col] = true;
                diag1[row - col + N] = true;
                diag2[row - col] = true;

                placeQueen(row + 1);

                cols[col] = false;
                diag1[row - col + N] = false;
                diag2[row - col] = false;
            }
        }
    }
}
