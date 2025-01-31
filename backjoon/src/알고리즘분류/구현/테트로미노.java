package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 테트로미노 {

    // 테트로미노의 기본 형태 정의 (I, O, T, Z, S)
    private static final int[][][] tetriminos = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // I 형태
            {{0, 0}, {1, 0}, {0, 1}, {1, 1}}, // O 형태
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, // T 형태
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, // Z 형태
            {{0, 0}, {0, 1}, {1, 0}, {1, -1}} // S 형태
    };

    private static int N, M;
    private static int[][] tetriminoBoard;
    private static int maxTetriminoSum = 0;

    // TODO: 테트로미노의 기본 형태 정의부터 테트로미노 배치하는 방법에 대해 잘 이해가 되지 않았다. 다시 한 번 더 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        tetriminoBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                tetriminoBoard[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        // 모든 테트로미노에 대해 순회한다.
        for (int[][] tetrimino : tetriminos) {
            // 모든 위치에 테트로미노를 배치해 본다.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    getMaxTetriminoSum(tetrimino, i, j);
                }
            }
        }

        bufferedWriter.write(String.valueOf(maxTetriminoSum));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 테트로미노를 startX, startY 위치에 배치하고 합을 계산한다.
    private static void getMaxTetriminoSum(int[][] tetrimino, int startX, int startY) {
        int tetriminoSum = 0;
        boolean canPlaceTetrimino = true;

        for (int[] block : tetrimino) {
            int x = startX + block[0];
            int y = startY + block[1];

            // 테트로미노를 배치할 종이의 경계를 벗어나면 배치할 수 없다.
            if (x < 0 || x >= N || y < 0 || y >= M) {
                canPlaceTetrimino = false;
                break;
            }
            tetriminoSum += tetriminoBoard[x][y];
        }

        if (canPlaceTetrimino) maxTetriminoSum = Math.max(maxTetriminoSum, tetriminoSum);
    }
}
