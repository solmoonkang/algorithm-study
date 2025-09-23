package 모든문제.level1;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 크레인인형뽑기게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int O = Integer.parseInt(bufferedReader.readLine());

        int[] moves = new int[O];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < O; i++) {
            moves[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int missingDollsNumber = craneDollGrabbingGame(board, moves);
        bufferedWriter.write(String.valueOf(missingDollsNumber));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int craneDollGrabbingGame(int[][] board, int[] moves) {
        // 크레인에서 집어 올린 인형을 보관하는 바구니
        Deque<Integer> bucket = new LinkedList<>();

        // 각 열의 가장 위에 있는 인형의 행 인덱스를 저장하는 배열
        int[] topIndexes = new int[board.length];
        Arrays.fill(topIndexes, board.length);

        // board 배열의 각 열을 위에서 아래로 순회하며, 0이 아닌 첫 번째 인형이 나타나는 행 인덱스를 topIndexes에 저장
        for (int column = 0; column < board.length; column++) {
            for (int row = 0; row < board.length; row++) {
                // 0이 아닌 첫 번째 인형을 만나는 순간 인덱스 배열에 행의 위치를 저장
                if (board[row][column] != 0) {
                    topIndexes[column] = row;
                    break;
                }
            }
        }

        int explodedDolls = 0;

        // moves의 순서대로 각 열의 맨 위에 있는 인형을 바구니에 옮기고, topIndexes[moves[i]]에 해당하는 값을 감소
        for (int move : moves) {
            // 1-based moves 값을 0-based 인덱스로 변환
            int currentColumnIndex = move - 1;
            // 현재 열의 가장 위에 있는 인형의 행 인덱스를 가져옴
            int currentRowTopIndex = topIndexes[currentColumnIndex];

            // 만약 해당 열에 인형이 없다면 다음 moves로 넘어가며, 인형이 없는 열은 topIndex가 board.length와 같거나 큼
            if (currentRowTopIndex >= board.length) continue;

            // board에서 인형을 집어 올렸을 때의 값
            int doll = board[currentRowTopIndex][currentColumnIndex];

            if (!bucket.isEmpty() && bucket.peekLast() == doll) {
                bucket.pollLast();
                explodedDolls += 2;
                continue;
            }
            bucket.offerLast(doll);

            // 인형을 집어 올렸으므로, board에서 해당 위치를 빈칸으로 만듦
            board[currentRowTopIndex][currentColumnIndex] = 0;

            // 다음번에 집을 인형의 위치를 한 칸 아래로 갱신
            topIndexes[currentColumnIndex]++;
        }

        return explodedDolls;
    }
}
