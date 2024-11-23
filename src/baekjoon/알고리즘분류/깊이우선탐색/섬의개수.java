package baekjoon.알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 섬의개수 {

    private static int W, H;
    private static boolean[][] visited;
    private static int[][] arrayLists;
    private static int countIsland = 0;

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            W = Integer.parseInt(stringTokenizer.nextToken());
            H = Integer.parseInt(stringTokenizer.nextToken());

            if (W == 0 && H == 0) break;

            visited = new boolean[H][W];
            arrayLists = new int[H][W];

            for (int i = 0; i < H; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                for (int j = 0; j < W; j++) {
                    arrayLists[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            countIsland = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (arrayLists[i][j] == 1 && !visited[i][j]) {
                        DFS(i, j);
                        countIsland++;
                    }
                }

            }

            bufferedWriter.write(countIsland + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                if (arrayLists[nx][ny] == 1 && !visited[nx][ny]) {
                    DFS(nx, ny);
                }
            }
        }
    }
}
