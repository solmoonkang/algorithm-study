package baekjoon.알고리즘분류.깊이우선탐색;

import java.io.*;

public class 적록색약 {

    private static int N;
    private static boolean[][] visited;
    private static int[][] arrayLists;
    private static int countNormal = 0;
    private static int countColorBlind = 0;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N][N];
        arrayLists = new int[N][N];

        for (int i = 0; i < N; i++) {
            String color = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                if (color.charAt(j) == 'R') arrayLists[i][j] = 1;
                else if (color.charAt(j) == 'G') arrayLists[i][j] = 2;
                else if (color.charAt(j) == 'B') arrayLists[i][j] = 3;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, false);
                    countNormal++;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, true);
                    countColorBlind++;
                }
            }
        }

        bufferedWriter.write(countNormal + " " + countColorBlind);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int x, int y, boolean isColorBlind) {
        visited[x][y] = true;

        int currentColor = arrayLists[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                int neighborColor = arrayLists[nx][ny];

                if (isColorBlind) {
                    if (currentColor == 1 || currentColor == 2) {
                        if (neighborColor == 1 || neighborColor == 2) DFS(nx, ny, true);
                    } else {
                        if (currentColor == neighborColor) DFS(nx, ny, true);
                    }
                } else {
                    if (currentColor == neighborColor) DFS(nx, ny, false);
                }
            }
        }
    }
}
