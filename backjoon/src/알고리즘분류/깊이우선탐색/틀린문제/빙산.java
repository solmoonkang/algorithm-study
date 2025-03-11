package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 빙산 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N, M;
    private static int[][] northPole;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        northPole = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                northPole[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int year = 0;

        while (true) {
            int count = countIcebergs();
            if (count == 0) {
                bufferedWriter.write("0");
                break;
            }

            if (count >= 2) {
                bufferedWriter.write(String.valueOf(year));
                break;
            }

            meltIcebergs();
            year++;

        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int countIcebergs() {
        boolean[][] visited = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (northPole[i][j] > 0 && !visited[i][j]) {
                    BFS(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void BFS(int x, int y, boolean[][] visited) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{x, y});
        visited[x][y] = true;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();

            for (int[] direction : DIRECTIONS) {
                int nx = current[0] + direction[0];
                int ny = current[1] + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && northPole[nx][ny] > 0) {
                    searchDeque.offerLast(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static void meltIcebergs() {
        int[][] tempNorthPole = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (northPole[i][j] > 0) {
                    int waterCount = 0;

                    for (int[] direction : DIRECTIONS) {
                        int nx = i + direction[0];
                        int ny = j + direction[1];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && northPole[nx][ny] == 0) {
                            waterCount++;
                        }
                    }

                    tempNorthPole[i][j] = Math.max(northPole[i][j] - waterCount, 0);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.arraycopy(tempNorthPole[i], 0, northPole[i], 0, M);
        }
    }
}
