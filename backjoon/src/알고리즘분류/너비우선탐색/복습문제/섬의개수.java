package 알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 섬의개수 {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    private static int W, H;
    private static boolean[][] visited;
    private static int[][] islandsAndOceanMap;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            W = Integer.parseInt(stringTokenizer.nextToken());
            H = Integer.parseInt(stringTokenizer.nextToken());
            if (W == 0 && H == 0) break;

            visited = new boolean[H][W];
            islandsAndOceanMap = new int[H][W];

            for (int i = 0; i < H; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < W; j++) {
                    islandsAndOceanMap[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            int numberOfIslands = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && islandsAndOceanMap[i][j] == 1) {
                        BFS(i, j);
                        numberOfIslands++;
                    }
                }
            }

            bufferedWriter.write(numberOfIslands + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS(int startX, int startY) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            for (int[] direction : directions) {
                int nx = current[0] + direction[0];
                int ny = current[1] + direction[1];

                if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny] && islandsAndOceanMap[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    searchDeque.offerLast(new int[]{nx, ny});
                }
            }
        }
    }
}
