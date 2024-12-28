package baekjoon.알고리즘분류.백트래킹.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 알파벳 {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final int ALPHABET_TYPES = 26;

    private static int R, C;
    private static boolean[] visited = new boolean[ALPHABET_TYPES];
    private static char[][] board;
    private static int maxHorseMoves = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String words = bufferedReader.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = words.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true;
        calculateMaxPath(0, 0, 1);
        bufferedWriter.write(String.valueOf(maxHorseMoves));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void calculateMaxPath(int x, int y, int moves) {
        maxHorseMoves = Math.max(maxHorseMoves, moves);

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                char nextAlphabet = board[nx][ny];
                if (!visited[nextAlphabet - 'A']) {
                    visited[nextAlphabet - 'A'] = true;
                    calculateMaxPath(nx, ny, moves + 1);
                    visited[nextAlphabet - 'A'] = false;
                }
            }
        }
    }
}
