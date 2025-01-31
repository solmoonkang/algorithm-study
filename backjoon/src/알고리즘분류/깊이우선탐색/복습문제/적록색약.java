package 알고리즘분류.깊이우선탐색.복습문제;

import java.io.*;

public class 적록색약 {

    private static int N;
    private static boolean[][] visited;
    private static int[][] arrayLists;
    private static int isColorBlind, isNotColorBlind;

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N][N];
        arrayLists = new int[N][N];

        for (int i = 0; i < N; i++) {
            String section = bufferedReader.readLine();

            for (int j = 0; j < N; j++) {
                if (section.charAt(j) == 'R') arrayLists[i][j] = 1;
                else if (section.charAt(j) == 'G') arrayLists[i][j] = 2;
                else if (section.charAt(j) == 'B') arrayLists[i][j] = 3;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, false);
                    isNotColorBlind++;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, true);
                    isColorBlind++;
                }
            }
        }

        bufferedWriter.write(isNotColorBlind + " " + isColorBlind);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int x, int y, boolean isColorBlind) {
        visited[x][y] = true;

        int currentColor = arrayLists[x][y];

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

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
