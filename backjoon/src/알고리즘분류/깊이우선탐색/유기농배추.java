package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 유기농배추 {

    private static int T, M, N, K;
    private static boolean[][] visited;
    private static int[][] cabbages;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            M = Integer.parseInt(stringTokenizer.nextToken());
            N = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());

            cabbages = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                int X = Integer.parseInt(stringTokenizer.nextToken());
                int Y = Integer.parseInt(stringTokenizer.nextToken());

                cabbages[X][Y] = 1;
            }

            int whiteWormCount = 0;

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (cabbages[x][y] == 1 && !visited[x][y]) {
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

    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (cabbages[nx][ny] == 1 && !visited[nx][ny]) DFS(nx, ny);
            }
        }
    }
}
