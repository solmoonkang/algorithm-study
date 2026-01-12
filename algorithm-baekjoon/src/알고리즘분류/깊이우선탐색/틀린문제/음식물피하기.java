package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.StringTokenizer;

public class 음식물피하기 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final char PROG = '#';
    private static final char EMPTY = '.';

    private static int N, M, K;
    private static boolean[][] visited;
    private static char[][] graphPositions;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N][M];
        graphPositions = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graphPositions[i][j] = EMPTY;
            }
        }

        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int topPosition = Integer.parseInt(stringTokenizer.nextToken());
            int leftPosition = Integer.parseInt(stringTokenizer.nextToken());

            graphPositions[topPosition - 1][leftPosition - 1] = PROG;
        }

        int biggestProgSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graphPositions[i][j] == PROG) {
                    // 새로운 음식물 덩어리를 발견할 때마다 DFS를 호출하여 그 덩어리의 크기를 계산하는 것이다.
                    // 즉, 현재 발견한 음식물 덩어리의 크기를 나타낸다.
                    int currentProgSize = DFS(i, j);
                    // 발견된 여러 덩어리 중에서 가장 큰 덩어리의 크기를 업데이트하는 역할을 한다.
                    // 현재까지 발견된 최대 크기와 현재 덩어리 크기를 비교하고, 더 큰 값으로 업데이트한다.
                    biggestProgSize = Math.max(biggestProgSize, currentProgSize);
                }
            }
        }

        bufferedWriter.write(String.valueOf(biggestProgSize));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int DFS(int x, int y) {
        visited[x][y] = true;
        // 현재 호출된 DFS가 방문한 정점을 나타낸다. 즉, DFS가 호출될 때마다 현재 정점(x, y)을 방문했으므로, 크기를 1로 초기화한다.
        int size = 1;

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && graphPositions[nx][ny] == PROG) {
                // 인접한 정점이 음식물일 경우, DFS를 재귀적으로 호출하여 해당 인접 정점의 크기도 계산하고 그 크기를 size에 더한다.
                size += DFS(nx, ny);
            }
        }

        return size;
    }
}
