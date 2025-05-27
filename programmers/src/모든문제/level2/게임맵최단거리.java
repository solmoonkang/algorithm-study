package 모든문제.level2;

import java.io.*;
import java.util.*;

public class 게임맵최단거리 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N, M;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] maps = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int destination = BFS(maps);
        bufferedWriter.write(String.valueOf(destination));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int[][] maps) {
        Deque<int[]> searchDeque = new ArrayDeque<>();
        searchDeque.offerLast(new int[]{0, 0});
        visited[0][0] = true;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            int x = current[0], y = current[1];

            for (int[] direction : DIRECTIONS) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    searchDeque.offerLast(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    maps[nx][ny] = maps[x][y] + 1;
                }
            }
        }

        int destination = maps[N - 1][M - 1];
        if (destination == 1) return -1;
        return destination;
    }
}
