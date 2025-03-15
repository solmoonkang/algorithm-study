package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.StringTokenizer;

public class 욕심쟁이판다 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N;
    private static int[][] bambooForest, dp;

    // 판다는 주변(상하좌우) 대나무를 먹고 이전에 먹었던 대나무보다 더 많은 대나무가 있는 지역으로 가야만 한다.
    // 어떤 지점에 처음 풀어야 하고, 어떤 곳으로 이동 시켜야 최대한 많은 칸을 방문할 수 있도록 해야 한다.
    // 판다가 있던 곳에 대나무가 몇 개 였는지, 그리고 앞으로 이동할 곳의 대나무가 몇 개인지 파악하여 비교한 후 이동을 할지 말지 결정해야 한다.

    // 위와 같이 단순 DFS로 구현할 경우, 한 번에 가장 긴 경로를 찾게 된다.
    // 모든 칸에서 DFS를 수행하면 중복 연산이 너무 많아져서 시간 초과가 발생할 수 있다.

    // 때문에 모든 칸에서 탐색을 시작할 수 있어 한 번 방문한 칸에서의 최대 이동 칸 수를 저장해야 한다.
    // 그래야 같은 칸에서 다시 탐색할 때 중복 계산을 방지할 수 있어 DFS로 탐색하면서 DP를 적용하면 해결이 가능하다.

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        bambooForest = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                bambooForest[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int maxMovement = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxMovement = Math.max(maxMovement, DFS(i, j));
            }
        }

        bufferedWriter.write(String.valueOf(maxMovement));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 단순히 DFS를 수행한다면 시간 초과가 발생할 가능성이 있으므로, 메모이제이션을 적용하여 한 번 탐색한 칸은 다시 탐색하지 않도록 한다.
    // 최적화로 인해 탐색 시간이 O(4^N)에서 O(N^2)으로 줄어들게 된다.
    private static int DFS(int x, int y) {
        // 이미 방문한 곳이면 저장된 값을 반환한다.
        if (dp[x][y] != 0) return dp[x][y];

        // 최소한 현재 위치에서 1칸은 이동할 수 있다.
        dp[x][y] = 1;

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            // 4방향 탐색을 수행하여, 현재 칸보다 대나무가 더 많은 곳으로 이동한다.
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && bambooForest[nx][ny] > bambooForest[x][y]) {
                // 이동할 수 있으면, 이동한 칸의 최댓값 + 1을 통해 dp[x][y]에 저장한다.
                dp[x][y] = Math.max(dp[x][y], DFS(nx, ny) + 1);
            }
        }

        return dp[x][y];
    }
}
