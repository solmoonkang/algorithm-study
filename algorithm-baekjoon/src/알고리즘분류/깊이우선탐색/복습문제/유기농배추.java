package 알고리즘분류.깊이우선탐색.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 유기농배추 {

    private static int M, N, K;
    private static boolean[][] visited;
    private static int[][] arrayLists;
    private static int whiteWormCount = 0;

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            M = Integer.parseInt(stringTokenizer.nextToken());
            N = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());

            visited = new boolean[M][N];
            arrayLists = new int[M][N];

            for (int j = 0; j < K; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());

                arrayLists[x][y] = 1;
            }

            whiteWormCount = 0;

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (arrayLists[x][y] == 1 && !visited[x][y]) {
                        DFS(x, y);
                        whiteWormCount++;
                    }
                }
            }

            bufferedWriter.write(whiteWormCount + "\n");
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

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (arrayLists[nx][ny] == 1 && !visited[nx][ny]) DFS(nx, ny);
            }
        }
    }
}
