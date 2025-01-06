package baekjoon.알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 나이트의이동 {

    private static final int[][] knightDirections = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };
    private static final int UNREACHABLE = -1;

    private static int chessBoardSize;
    private static boolean[][] visited;
    private static int[] currentKnightPosition;
    private static int[] targetKnightPosition;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            chessBoardSize = Integer.parseInt(bufferedReader.readLine());

            visited = new boolean[chessBoardSize][chessBoardSize];

            String[] currentPositionInput = bufferedReader.readLine().split(" ");
            currentKnightPosition = new int[2];
            currentKnightPosition[0] = Integer.parseInt(currentPositionInput[0]);
            currentKnightPosition[1] = Integer.parseInt(currentPositionInput[1]);

            String[] targetPositionInput = bufferedReader.readLine().split(" ");
            targetKnightPosition = new int[2];
            targetKnightPosition[0] = Integer.parseInt(targetPositionInput[0]);
            targetKnightPosition[1] = Integer.parseInt(targetPositionInput[1]);

            int minKnightMovesNumber = BFS();
            bufferedWriter.write(minKnightMovesNumber + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS() {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{currentKnightPosition[0], currentKnightPosition[1], 0});
        visited[currentKnightPosition[0]][currentKnightPosition[1]] = true;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == targetKnightPosition[0] && y == targetKnightPosition[1]) return distance;

            for (int[] direction : knightDirections) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < chessBoardSize && ny >= 0 && ny < chessBoardSize && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    searchDeque.offerLast(new int[]{nx, ny, distance + 1});
                }
            }
        }

        return UNREACHABLE;
    }
}
