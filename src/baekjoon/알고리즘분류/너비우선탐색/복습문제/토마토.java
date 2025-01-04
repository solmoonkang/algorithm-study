package baekjoon.알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 토마토 {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final int INITIAL_DAYS = 0;
    private static final String NOT_ALL_TOMATOES_ARE_RIPE = "-1";

    private static int M, N;
    private static int[][] tomatoBox;

    // TODO: M을 열의 수 즉, 가로 칸으로 N을 행의 수 즉, 세로 칸으로 지정해야 한다.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());

        tomatoBox = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int maxTomatoRipeDays = BFS();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoBox[i][j] == 0) {
                    bufferedWriter.write(NOT_ALL_TOMATOES_ARE_RIPE);
                    bufferedWriter.flush();
                    return;
                }
            }
        }

        bufferedWriter.write(String.valueOf(maxTomatoRipeDays));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS() {
        Deque<int[]> searchDeque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoBox[i][j] == 1) searchDeque.offerLast(new int[]{i, j});
            }
        }

        int days = 0;
        while (!searchDeque.isEmpty()) {
            int size = searchDeque.size();

            for (int i = 0; i < size; i++) {
                int[] current = searchDeque.pollFirst();
                int x = current[0];
                int y = current[1];

                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && tomatoBox[nx][ny] == 0) {
                        tomatoBox[nx][ny] = 1;
                        searchDeque.offerLast(new int[]{nx, ny});
                    }
                }
            }

            days++;
        }

        return days > INITIAL_DAYS ? days - 1 : INITIAL_DAYS;
    }
}
