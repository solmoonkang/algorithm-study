package 알고리즘분류.백트래킹.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 스도쿠 {

    private static final int SUDOKU_SIZE = 9;
    private static final int[][] sudokuGameBoard = new int[SUDOKU_SIZE][SUDOKU_SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < SUDOKU_SIZE; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < SUDOKU_SIZE; j++) {
                sudokuGameBoard[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        // 백트래킹을 사용해야 하는 이유: 각 가로줄과 세로줄에서 그리고 3x3 크기의 정사각형 안에서 1부터 9까지의 모든 숫자를 구하는 경우의 수
        // 조건문이 총 3번 있어야 하지 않을까? 가로줄 + 세로줄 + 3x3 정사각형

        // 이후, 백트래킹 메서드를 통해 depth == SUDOKU_SIZE 라면, 위 조건문이 있는 메서드를 실행하는 것이다.
        // 또한, 기존 배열을 건드리면 손상이 가므로, 복제를 통해 구현을 해야 하지 않을까?

        if (fillSudokuGameBoard(0, 0)) {
            for (int i = 0; i < SUDOKU_SIZE; i++) {
                for (int j = 0; j < SUDOKU_SIZE; j++) {
                    bufferedWriter.write(sudokuGameBoard[i][j] + " ");
                }
                bufferedWriter.newLine();
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean fillSudokuGameBoard(int row, int col) {
        if (col == SUDOKU_SIZE) {
            col = 0;
            row++;
        }

        if (row == SUDOKU_SIZE) {
            return true;
        }

        if (sudokuGameBoard[row][col] != 0) {
            return fillSudokuGameBoard(row, col + 1);
        }

        for (int number = 1; number <= 9; number++) {
            if (isPlacementValid(row, col, number)) {
                sudokuGameBoard[row][col] = number;
                if (fillSudokuGameBoard(row, col + 1)) return true;
                sudokuGameBoard[row][col] = 0;
            }
        }

        return false;
    }

    private static boolean isPlacementValid(int row, int col, int number) {
        for (int j = 0; j < SUDOKU_SIZE; j++) {
            if (sudokuGameBoard[row][j] == number) return false;
        }

        for (int i = 0; i < SUDOKU_SIZE; i++) {
            if (sudokuGameBoard[i][col] == number) return false;
        }

        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;

        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (sudokuGameBoard[i][j] == number) return false;
            }
        }

        return true;
    }
}
