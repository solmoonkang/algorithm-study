package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치즈 {

    /**
     * BFS가 직관적인 이유
     * 외부 공기를 탐색하는 방식으로 주변을 하나씩 탐색하면서 확장해야 하는 문제는 DFS보다 BFS가 직관적이다.
     * 큐를 사용하기 때문에 내부 공기와 외부 공기를 분리하는 데 용이하다.
     */

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N, M;
    private static boolean[][] visited;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int time = 0;
        while (true) {
            // 이를 처리하기 위해 DFS 함수를 (0, 0)부터 DFS를 돌면서, 치즈 바깥에 있는 모든 0을 방문 처리한다.
            // 즉, visited == true인 0은 외부 공기이므로, visited를 사용하지 않으면 내부 공기와 외부 공기를 구분할 수 없다.
            visited = new boolean[N][M];
            DFS(0, 0);

            // 문제의 핵심은 치즈가 동시에 녹아야 한다는 점이다. 만약 치즈를 탐색하면서 바로 녹여버리면 문제가 발생한다.
            // 예를 들어, 탐색 중 치즈를 바로 녹이면, 바로 녹인 치즈 때문에 다른 치즈가 영향을 받을 수 있게 된다.
            // 따라서 녹을 치즈를 먼저 리스트에 저장해둔 후, 한꺼번에 0으로 만들어야 한다. -> 시뮬레이션 방식.
            List<int[]> toMelt = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1 && shouldMelt(i, j)) toMelt.add(new int[]{i, j});
                }
            }

            // 더 이상 녹일 치즈가 없다면 종료한다. 즉, 리스트가 비었다면 녹을 치즈가 하나도 남아있지 않다는 의미이다.
            if (toMelt.isEmpty()) break;

            // shouldMelt 함수를 통해 녹을 치즈를 toMelt 리스트에 저장하였고, 이를 모두 한 번에 녹이는 작업을 진행한다.
            // 만약, toMelt 없이 즉시 graph[i][j] = 0을 한다면 동시에 녹는 것이 아닌 순차적으로 녹아 문제가 발생할 수 있다.
            for (int[] position : toMelt) {
                graph[position[0]][position[1]] = 0;
            }

            time++;
        }

        bufferedWriter.write(String.valueOf(time));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // DFS는 외부 공기를 탐색하는 함수로, 외부 공기와 접촉한 치즈가 녹기 때문에 어떤 공기가 외부 공기인지 구분해야 한다.
    // 여기서 내부에 있는 0(치즈 안쪽 공기)은 외부 공기가 아니므로, 외부 공기(치즈 바깥쪽에 있는 0)만 따로 탐색해야 한다.
    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                if (graph[nx][ny] == 0) DFS(nx, ny);
            }
        }
    }

    // DFS 함수를 통해 외부 공기가 어디까지인지 찾는 역할을 구현했다면, 치즈가 녹을지 판단하는 역할을 구현해줘야 한다.
    // shouldMelt 함수는 각 치즈가 녹을지를 판별하는 탐색을 하게 된다.
    private static boolean shouldMelt(int x, int y) {
        int airCount = 0;

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny]) {
                airCount++;
            }
        }

        return airCount >= 2;
    }
}
