package baekjoon.알고리즘분류.브루트포스알고리즘;

import java.io.*;
import java.util.StringTokenizer;

public class 체스판다시칠하기 {

    private static final int S = 8;

    // TODO: 문제를 작은 단위로 나눠서 단계별로 접근하도록 해보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = bufferedReader.readLine().toCharArray();
        }

        int minChanges = Integer.MAX_VALUE;

        for (int i = 0; i <= N - S; i++) {
            for (int j = 0; j <= M - S; j++) {
                int changes1 = 0;
                int changes2 = 0;

                for (int x = 0; x < S; x++) {
                    for (int y = 0; y < S; y++) {
                        char expected1 = ((x + y) % 2 == 0) ? 'W' : 'B';
                        char expected2 = ((x + y) % 2 == 0) ? 'B' : 'W';

                        if (board[i + x][j + y] != expected1) changes1++;
                        if (board[i + x][j + y] != expected2) changes2++;
                    }
                }

                minChanges = Math.min(minChanges, Math.min(changes1, changes2));
            }
        }

        bufferedWriter.write(String.valueOf(minChanges));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
