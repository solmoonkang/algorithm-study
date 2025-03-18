package 알고리즘분류.깊이우선탐색.흐름문제;

import java.io.*;

public class 적록색약 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N;
    private static boolean[][] visitedNormal, visitedBlind;
    private static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visitedNormal = new boolean[N][N];
        visitedBlind = new boolean[N][N];
        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            String colors = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = colors.charAt(j);
            }
        }

        int normalCount = 0;
        int blindCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedNormal[i][j]) {
                    DFS(i, j, false);
                    normalCount++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedBlind[i][j]) {
                    DFS(i, j, true);
                    blindCount++;
                }
            }
        }

        bufferedWriter.write(normalCount + " " + blindCount);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int x, int y, boolean isBlind) {
        if (isBlind) visitedBlind[x][y] = true;
        else visitedNormal[x][y] = true;

        char currentColor = grid[x][y];

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (isBlind && !visitedBlind[nx][ny]) {
                    // 현재 위치의 색이 R 또는 G이고, 다음 탐색할 위치의 색이 R 또는 G일 경우
                    if ((currentColor == 'R' || currentColor == 'G') && (grid[nx][ny] == 'R' || grid[nx][ny] == 'G')) {
                        DFS(nx, ny, true);

                    // 현재 위치의 색과 다음 위치의 색이 동일한 경우
                    } else if (currentColor == grid[nx][ny]) {
                        DFS(nx, ny, true);
                    }
                } else if (!isBlind && !visitedNormal[nx][ny]) {
                    if (currentColor == grid[nx][ny]) {
                        DFS(nx, ny, false);
                    }
                }
            }
        }
    }
}
