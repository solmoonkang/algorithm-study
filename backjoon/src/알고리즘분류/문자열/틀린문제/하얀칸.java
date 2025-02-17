package 알고리즘분류.문자열.틀린문제;

import java.io.*;

public class 하얀칸 {

    private static final int CHESS_BOARD_SIZE = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] chessBoard = new char[CHESS_BOARD_SIZE][CHESS_BOARD_SIZE];

        for (int i = 0; i < CHESS_BOARD_SIZE; i++) {
            String chessBoardState = bufferedReader.readLine();
            for (int j = 0; j < CHESS_BOARD_SIZE; j++) {
                chessBoard[i][j] = chessBoardState.charAt(j);
            }
        }

        int whiteChessHorseNumber = 0;

        // 하얀색 칸은 i + j가 짝수인 위치에 있고, 검정색 칸은 i + j가 홀수인 위치에 있다.
        for (int i = 0; i < CHESS_BOARD_SIZE; i++) {
            for (int j = 0; j < CHESS_BOARD_SIZE; j++) {
                if ((i + j) % 2 == 0) {
                    if (chessBoard[i][j] == 'F') whiteChessHorseNumber++;
                }
            }
        }

        bufferedWriter.write(String.valueOf(whiteChessHorseNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
