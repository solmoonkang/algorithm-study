package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 안전영역 {

    private static int N;
    private static boolean[][] visited;
    private static int[][] arrayLists;

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N][N];
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
            int safeArea = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arrayLists[i][j] > rainHeight && !visited[i][j]) {
                        DFS(i, j, rainHeight);
                        safeArea++;
                    }
                }
            }

            maxSafeArea = Math.max(maxSafeArea, safeArea);
        }

        bufferedWriter.write(String.valueOf(maxSafeArea));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int x, int y, int rainHeight) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (arrayLists[nx][ny] > rainHeight && !visited[nx][ny]) DFS(nx, ny, rainHeight);
            }
        }
    }
}
