package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 섬의개수 {

    private static final int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    private static int W, H;
    private static boolean[][] visited;
    private static int[][] arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            W = Integer.parseInt(stringTokenizer.nextToken());
            H = Integer.parseInt(stringTokenizer.nextToken());

            if (W == 0 && H == 0) break;

            arrayLists = new int[H][W];
            for (int i = 0; i < H; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < W; j++) {
                    arrayLists[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            visited = new boolean[H][W];

            int island = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && arrayLists[i][j] == 1) {
                        BFS(i, j);
                        island++;
                    }
                }
            }

            bufferedWriter.write(island + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS(int startX, int startY) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!searchDeque.isEmpty()) {
            int[] currentIsland = searchDeque.pollFirst();

            int x = currentIsland[0];
            int y = currentIsland[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny] && arrayLists[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    searchDeque.add(new int[]{nx, ny});
                }
            }
        }
    }
}
