package baekjoon.알고리즘분류.문자열;

import java.io.*;

public class 하얀칸 {

    private static final int N = 8;

    // TODO: 하얀 칸은 짝수, 검은 칸은 홀수 인덱스로 고정되어 있는 걸로 착각해서 문제를 풀었음. 하얀 칸은 짝수와 홀수를 조합하여 나타낸다.
    //  - 행의 인덱스가 짝수일 때는 열의 인덱스가 짝수인 칸이 하얀색이고,
    //  - 행의 인덱스가 홀수일 때는 열의 인덱스가 홀수인 칸이 하얀색이다.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] chessBoard = new String[N];

        for (int i = 0; i < N; i++) {
            chessBoard[i] = bufferedReader.readLine();
        }

        int numberOfPiecesOnWhiteSquares = findPiecesOnWhiteSquares(chessBoard);
        bufferedWriter.write(String.valueOf(numberOfPiecesOnWhiteSquares));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int findPiecesOnWhiteSquares(String[] chessBoard) {
        int numberOfPiecesOnWhiteSquares = 0;

        for (int i = 0; i < chessBoard.length; i++) {
            String currentChessBoard = chessBoard[i];

            for (int j = 0; j < currentChessBoard.length(); j++) {
                if ((i + j) % 2 == 0) {
                    if (currentChessBoard.charAt(j) == 'F') numberOfPiecesOnWhiteSquares++;
                }
            }
        }

        return numberOfPiecesOnWhiteSquares;
    }
}
