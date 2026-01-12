package 알고리즘분류.깊이우선탐색.흐름문제;

import java.io.*;
import java.util.StringTokenizer;

public class 유기농배추 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int M, N, K;
    private static boolean[][] visited;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            M = Integer.parseInt(stringTokenizer.nextToken());
            N = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());

            graph = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());

                graph[x][y] = 1;
            }

            int cabbageWhiteWorm = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && graph[i][j] == 1) {
                        DFS(i, j);
                        cabbageWhiteWorm++;
                    }
                }
            }

            bufferedWriter.write(cabbageWhiteWorm + "\n");
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

            // !visited[nx][ny]를 확인하는 과정이 마지막에 있어, 배추가 있는 위치(1)이지만 이미 방문한 경우에도 탐색을 시도하는 문제가 발생할 수 있다.
            // 따라서 graph[nx][ny] = 1 체크를 앞에 배치하여 방문할 가치가 있는 곳인지 먼저 확인하고, !visited[nx][ny]를 끝에 배치하여 이미 방문한 곳은 스킵하도록 한다.
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && graph[nx][ny] == 1 && !visited[nx][ny]) {
                DFS(nx, ny);
            }
        }
    }
}
