package 알고리즘분류.구현;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이차원배열의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] sequences = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                sequences[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int K = Integer.parseInt(bufferedReader.readLine());

        int[][] directions = new int[K][4];
        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            directions[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            directions[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            directions[i][2] = Integer.parseInt(stringTokenizer.nextToken());
            directions[i][3] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[][] prefixSum = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + sequences[i - 1][j - 1];
            }
        }

        for (int[] direction : directions) {
            int i = direction[0], j = direction[1];
            int x = direction[2], y = direction[3];

            int sum = prefixSum[x][y] - prefixSum[i - 1][y] - prefixSum[x][j - 1] + prefixSum[i - 1][j - 1];
            bufferedWriter.write(sum + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
