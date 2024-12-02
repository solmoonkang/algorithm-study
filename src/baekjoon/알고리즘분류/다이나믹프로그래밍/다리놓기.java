package baekjoon.알고리즘분류.다이나믹프로그래밍;

import java.io.*;
import java.util.StringTokenizer;

public class 다리놓기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            int bridgeCombinations = countBridgeCombinations(N, M);
            bufferedWriter.write(bridgeCombinations + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 부분 문제 정의
     * N개의 서쪽 사이트와 M개의 동쪽 사이트에서 다리를 지을 수 있는 경우의 수 -> N-1개의 서쪽 사이트와 M-1개의 동쪽 사이트에 다리를 지을 수 있는 경우의 수
     *
     * 점화식 유도
     * 마지막 동쪽 사이트를 선택하는 경우와 선택하지 않는 경우로 나누어 점화식을 유도
     */
    private static int countBridgeCombinations(int N, int M) {
        int[][] dynamicArray = new int[N + 1][M + 1];

        for (int i = 0; i <= M; i++) {
            dynamicArray[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dynamicArray[i][j] = dynamicArray[i - 1][j - 1] + dynamicArray[i][j - 1];
            }
        }

        return dynamicArray[N][M];
    }
}
