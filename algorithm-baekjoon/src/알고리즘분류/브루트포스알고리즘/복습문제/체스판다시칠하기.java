package 알고리즘분류.브루트포스알고리즘.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 체스판다시칠하기 {

    private static int N, M;
    private static char[][] chessBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        chessBoard = new char[N][M];

        for (int i = 0; i < N; i++) {
            chessBoard[i] = bufferedReader.readLine().toCharArray();
        }

        int minPaint = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= N - 8; j++) {
                minPaint = Math.min(minPaint, getRepaintCount(i, j));
            }
        }

        bufferedWriter.write(String.valueOf(minPaint));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getRepaintCount(int x, int y) {
        int repaint1 = 0;
        int repaint2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // 체스판은 항상 검은색과 흰색이 번갈아가면서 배치되어 있어, 행과 열의 합이 짝수일 때와 홀수일 때, 색상이 다르게 반복된다.
                char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';

                if (chessBoard[x + i][y + j] != expectedW) repaint1++;
                if (chessBoard[x + i][y + j] != expectedB) repaint2++;
            }
        }

        return Math.min(repaint1, repaint2);
    }
}
