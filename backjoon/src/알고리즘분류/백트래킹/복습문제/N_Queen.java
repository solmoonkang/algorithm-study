package 알고리즘분류.백트래킹.복습문제;

import java.io.*;

public class N_Queen {

    private static int N;
    private static int nonAttackingWays = 0;
    private static boolean[] column;                // 열 체크
    private static boolean[] rightDiagonal1;        // 대각선 체크 (우상향)
    private static boolean[] rightDiagonal2;        // 대각선 체크 (우하향)

    // N개의 Queen을 서로 공격할 수 없도록 하기 위해서는 같은 행, 같은 열, 대각선에 Queen이 서로 위치하면 안된다.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        column = new boolean[N];                    // 각 열에 Queen이 놓이는지 여부
        rightDiagonal1 = new boolean[2 * N];        // 대각선 체크 (i - j)
        rightDiagonal2 = new boolean[2 * N];        // 대각선 체크 (i + j)

        placeQueenConfigurations(0);

        bufferedWriter.write(String.valueOf(nonAttackingWays));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void placeQueenConfigurations(int depth) {
        if (depth == N) {
            nonAttackingWays++;
            return;
        }

        // column, rightDiagonal1, rightDiagonal2 배열 추가: 열과 대각선에서 Queen이 놓일 수 있는지를 체크하기 위한 배열이다.
        //  - column[i]: i번째 열에 Queen이 놓여 있는지를 체크한다.
        //  - rightDiagonal1[depth - i + N]: 우상향 대각선(i - j)을 체크한다. depth - i의 값이 음수가 될 수 있으므로 N을 더해준다.
        //  - rightDiagonal2[depth + i]: 우하향 대각선(i + j)을 체크한다.
        // Queen의 배치 조건 체크: Queen을 놓기 전에 해당 열과 대각선이 사용 중인지 체크하여, 조건을 만족할 때만 Queen을 배치한다.
        for (int i = 0; i < N; i++) {
            if (isPlacementPossible(depth, i)) {
                column[i] = true;       // 선택
                rightDiagonal1[depth - i + N] = true;       // 우상향 대각선 선택
                rightDiagonal2[depth + i] = true;           // 우하향 대각선 선택

                placeQueenConfigurations(depth + 1);        // 다음 깊이로 재귀 호출

                column[i] = false;      // 백트래킹: 선택 취소
                rightDiagonal1[depth - i + N] = false;      // 백트래킹: 우상향 대각선 선택 취소
                rightDiagonal2[depth + i] = false;          // 백트래킹: 우하향 대각선 선택 취소
            }
        }
    }

    private static boolean isPlacementPossible(int depth, int col) {
        return !column[col] && !rightDiagonal1[depth - col + N] && !rightDiagonal2[depth + col];    // 열, 대각선 체크
    }
}
