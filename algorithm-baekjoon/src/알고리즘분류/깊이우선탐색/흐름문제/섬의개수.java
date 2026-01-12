package 알고리즘분류.깊이우선탐색.흐름문제;

import java.io.*;
import java.util.StringTokenizer;

public class 섬의개수 {

    private static final int[][] DIRECTIONS = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},       // 가로, 세로
            {1, 1}, {-1, 1}, {1, -1}, {-1, -1}      // 대각선
    };

    private static int W, H;
    private static boolean[][] visited;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            W = Integer.parseInt(stringTokenizer.nextToken());
            H = Integer.parseInt(stringTokenizer.nextToken());

            if (W == 0 && H == 0) break;

            visited = new boolean[H][W];
            graph = new int[H][W];

            for (int i = 0; i < H; i++) {
                String[] map = bufferedReader.readLine().split(" ");
                for (int j = 0; j < W; j++) {
                    graph[i][j] = Integer.parseInt(map[j]);
                }
            }

            int island = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && graph[i][j] == 1) {
                        DFS(i, j);
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

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny] && graph[nx][ny] == 1) {
                DFS(nx, ny);
            }
        }
    }
}
