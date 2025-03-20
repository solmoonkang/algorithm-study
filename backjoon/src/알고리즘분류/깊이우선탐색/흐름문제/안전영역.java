package 알고리즘분류.깊이우선탐색.흐름문제;

import java.io.*;
import java.util.StringTokenizer;

public class 안전영역 {

    /**
     * 문제에서 비의 양에 따라 안전 구역 개수가 달라진다고 하였으므로,
     * 각 높이마다 확인을 하면서 가장 높은 높이에 다다를 때까지 반복을 하고 그 중 가장 많은 안전 구역을 확보했을 때의 안전 구역 개수를 반환해야 한다.
     * 따라서, 입력을 받을 때 그래프에 추가되는 값 중 최대 높이 값을 구한다.
     * 이후, 해당 높이까지 반복을 통해서 최대 안전 구역 개수를 구하여 반환하도록 한다.
     */

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        graph = new int[N][N];
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                // 그래프에서 가장 높은 지역의 높이를 조사한다.
                maxHeight = Math.max(maxHeight, graph[i][j]);
            }
        }

        int maxSafeAreas = 0;

        // 비의 높이를 1부터 maxHeight까지 변화시키면서 안전 구역 개수를 구한다.
        for (int height = 0; height <= maxHeight; height++) {
            boolean[][] visited = new boolean[N][N];
            int safeAreaCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 비가 maxHeight + 1 이상 오면 모든 지역이 잠기므로 탐색할 필요가 없다.
                    if (!visited[i][j] && graph[i][j] > height) {
                        DFS(i, j, height, visited);
                        safeAreaCount++;
                    }
                }

                maxSafeAreas = Math.max(maxSafeAreas, safeAreaCount);
            }
        }

        bufferedWriter.write(String.valueOf(maxSafeAreas));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int x, int y, int height, boolean[][] visited) {
        visited[x][y] = true;

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && graph[nx][ny] > height) {
                DFS(nx, ny, height, visited);
            }
        }
    }
}
