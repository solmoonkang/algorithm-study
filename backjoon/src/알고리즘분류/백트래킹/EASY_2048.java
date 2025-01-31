package 알고리즘분류.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class EASY_2048 {

    private static final int MAX_MOVES = 5;

    private static int N;
    private static int[][] board;
    private static int maxBlock = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        simulateEasy2048BoardGame(board, 0);
        bufferedWriter.write(String.valueOf(maxBlock));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void simulateEasy2048BoardGame(int[][] easy2048Board, int moves) {
        // 현재 보드에서 최대 블록 값을 업데이트한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxBlock = Math.max(maxBlock, easy2048Board[i][j]);
            }
        }

        // 5번 이하의 이동만 허용한다.
        if (moves >= MAX_MOVES) return;

        // 상, 하, 좌, 우 4 방향으로 이동할 수 있도록 시뮬레이션한다.
        for (int direction = 0; direction < 4; direction++) {
            int[][] currentEasy2048Board = getMaxBlockAfterMoves(easy2048Board, direction);
            simulateEasy2048BoardGame(currentEasy2048Board, moves + 1);
        }
    }

    private static int[][] getMaxBlockAfterMoves(int[][] easy2048Board, int direction) {
        int[][] currentEasy2048Board = new int[N][N];

        // 0: 위, 1: 아래, 2: 왼쪽, 3: 오른쪽으로 이동할 수 있는 이동 로직
        switch (direction) {
            case 0:
                for (int j = 0; j < N; j++) {
                    int index = 0;
                    for (int i = 0; i < N; i++) {
                        if (easy2048Board[i][j] != 0) {

                            if (currentEasy2048Board[index][j] == 0) {
                                currentEasy2048Board[index][j] = easy2048Board[i][j];
                            } else if (currentEasy2048Board[index][j] == easy2048Board[i][j]) {
                                currentEasy2048Board[index][j] *= 2;
                                index++;
                            } else {
                                index++;
                                currentEasy2048Board[index][j] = easy2048Board[i][j];
                            }
                        }
                    }
                }
                break;

            case 1:
                for (int j = 0; j < N; j++) {
                    int index = N - 1;
                    for (int i = N - 1; i >= 0; i--) {
                        if (easy2048Board[i][j] != 0) {

                            if (currentEasy2048Board[index][j] == 0) {
                                currentEasy2048Board[index][j] = easy2048Board[i][j];
                            } else if (currentEasy2048Board[index][j] == easy2048Board[i][j]) {
                                currentEasy2048Board[index][j] *= 2;
                                index--;
                            } else {
                                index--;
                                currentEasy2048Board[index][j] = easy2048Board[i][j];
                            }
                        }
                    }
                }
                break;

            case 2:
                for (int i = 0; i < N; i++) {
                    int index = 0;
                    for (int j = 0; j < N; j++) {
                        if (easy2048Board[i][j] != 0) {

                            if (currentEasy2048Board[i][index] == 0) {
                                currentEasy2048Board[i][index] = easy2048Board[i][j];
                            } else if (currentEasy2048Board[i][index] == easy2048Board[i][j]) {
                                currentEasy2048Board[i][index] *= 2;
                                index++;
                            } else {
                                index++;
                                currentEasy2048Board[i][index] = easy2048Board[i][j];
                            }
                        }
                    }
                }
                break;

            case 3:
                for (int i = 0; i < N; i++) {
                    int index = N - 1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (easy2048Board[i][j] != 0) {

                            if (currentEasy2048Board[i][index] == 0) {
                                currentEasy2048Board[i][index] = easy2048Board[i][j];
                            } else if (currentEasy2048Board[i][index] == easy2048Board[i][j]) {
                                currentEasy2048Board[i][index] *= 2;
                                index--;
                            } else {
                                index--;
                                currentEasy2048Board[i][index] = easy2048Board[i][j];
                            }
                        }
                    }
                }
                break;
        }

        return currentEasy2048Board;
    }
}
