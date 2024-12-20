package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class 스도쿠 {

    private static final int SUDOKU_DIMENSION = 9;

    private static int[][] sudokuBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        sudokuBoard = new int[SUDOKU_DIMENSION][SUDOKU_DIMENSION];

        for (int i = 0; i < SUDOKU_DIMENSION; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < SUDOKU_DIMENSION; j++) {
                sudokuBoard[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        renderSudokuBoard();
        for (int i = 0; i < SUDOKU_DIMENSION; i++) {
            for (int j = 0; j < SUDOKU_DIMENSION; j++) bufferedWriter.write(sudokuBoard[i][j] + " ");
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean renderSudokuBoard() {
        for (int i = 0; i < SUDOKU_DIMENSION; i++) {
            for (int j = 0; j < SUDOKU_DIMENSION; j++) {
                if (sudokuBoard[i][j] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (isValidSudokuBoard(i, j, number)) {
                            sudokuBoard[i][j] = number;
                            if (renderSudokuBoard()) return true;
                            sudokuBoard[i][j] = 0;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValidSudokuBoard(int row, int column, int number) {
        // 행 검사
        for (int i = 0; i < SUDOKU_DIMENSION; i++) {
            if (sudokuBoard[row][i] == number) return false;
        }

        // 열 검사
        for (int i = 0; i < SUDOKU_DIMENSION; i++) {
            if (sudokuBoard[i][column] == number) return false;
        }

        // 3x3 박스 검사
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (column / 3) * 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (sudokuBoard[i][j] == number) return false;
            }
        }

        return true;
    }
}
