package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 안전영역 {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int N;
    private static boolean[][] visited;
    private static int[][] arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        arrayLists = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                arrayLists[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int maxSafeArea = 0;
        for (int rainHeight = 0; rainHeight <= 100; rainHeight++) {
            visited = new boolean[N][N];
            int safeAreaCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arrayLists[i][j] > rainHeight && !visited[i][j]) {
                        BFS(i, j, rainHeight);
                        safeAreaCount++;
                    }
                }
            }

            maxSafeArea = Math.max(maxSafeArea, safeAreaCount);
        }

        bufferedWriter.write(String.valueOf(maxSafeArea));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS(int startX, int startY, int rainHeight) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.add(new int[]{startX, startY});

        visited[startX][startY] = true;

        while (!searchDeque.isEmpty()) {
            int[] currentArea = searchDeque.pollFirst();

            int x = currentArea[0];
            int y = currentArea[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && arrayLists[nx][ny] > rainHeight) {
                    visited[nx][ny] = true;
                    searchDeque.add(new int[]{nx, ny});
                }
            }
        }
    }
}
