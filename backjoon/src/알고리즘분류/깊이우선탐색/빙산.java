package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 빙산 {

    // TODO: 빙산의 상태를 시뮬레이션하고, 매년 빙산의 높이를 감소시키며, 빙산이 분리되는지 확인하는 부분에 대한 이해가 부족하다.

    private static int N, M;
    private static boolean[][] visited;
    private static int[][] arrayLists;

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arrayLists = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                arrayLists[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int year = 0;

        while (true) {
            if (isAllMelted()) {
                bufferedWriter.write("0");
                return;
            }

            meltIceberg();

            visited = new boolean[N][M];
            int parts = countIcebergParts();

            if (parts >= 2) {
                bufferedWriter.write(String.valueOf(year + 1));
                break;
            }

            year++;
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void meltIceberg() {
        int[][] newIceberg = new int[N][M];

        for (int i = 0; i < N; i++) {
            System.arraycopy(arrayLists[i], 0, newIceberg[i], 0, M);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arrayLists[i][j] > 0) {
                    int seaCount = 0;

                    for (int[] direction : directions) {
                        int nx = i + direction[0];
                        int ny = j + direction[1];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            if (arrayLists[nx][ny] == 0) seaCount++;
                        }
                    }

                    newIceberg[i][j] = Math.max(0, arrayLists[i][j] - seaCount);
                }
            }
        }

        arrayLists = newIceberg;
    }

    private static int countIcebergParts() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arrayLists[i][j] > 0 && !visited[i][j]) {
                    count++;
                    DFS(i, j);
                }
            }
        }

        return count;
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (arrayLists[nx][ny] > 0 && !visited[nx][ny]) DFS(nx, ny);
            }
        }
    }

    private static boolean isAllMelted() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arrayLists[i][j] > 0) return false;
            }
        }

        return true;
    }
}
