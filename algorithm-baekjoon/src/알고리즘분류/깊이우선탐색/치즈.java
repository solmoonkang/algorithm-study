package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 치즈 {

    /**
     * BFS가 DFS보다 더 효율적인 이유
     * <p>
     * 1. 공기의 확산
     * - BFS는 외부에서 내부로 공기가 퍼지는 과정을 자연스럽게 시뮬레이션한다.
     * - 가장자리에 있는 공기가 내부로 확산되는 순서를 정확하게 추적할 수 있다.
     * 2. 레벨 기반 탐색
     * - BFS는 현재 레벨(시간 단위)에서 가능한 모든 경로를 탐색하므로, 치즈가 녹는 조건을 확인하기에 적합하다.
     * 3. 효율적인 탐색
     * - BFS는 큐를 사용하여 탐색하기 때문에 각 노드를 한 번만 방문하여, 조건에 맞는 노드를 쉽게 찾을 수 있다.
     * <p>
     * DFS는 경로를 깊게 탐색하므로 공기가 치즈에 닿는 순서를 추적하기 어렵고, 모든 경로를 탐색하느라 비효율적일 수 있다.
     */

    /**
     * 코드의 전체적인 흐름
     * <p>
     * 1. 모눈종이의 크기 N, M을 입력으로 받는다.
     * 2. 치즈가 모두 녹을 때까지 반복한다.
     * - BFS를 통해 외부에서 공기가 들어오는 경로를 탐색한다.
     * - 각 치즈의 외부 공기와의 접촉 정도를 확인하여 녹을 치즈를 결정한다.
     * - 녹은 치즈를 상태에서 제거한다.
     * 3. 모든 치즈가 녹으면 시간을 출력하고 종료한다.
     */

    private static int N, M;
    private static boolean[][] visited;
    private static int[][] arrayLists;
    private static Deque<int[]> deque;

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N][M];
        arrayLists = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                arrayLists[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int meltingTime = 0;

        while (true) {
            boolean[][] melt = new boolean[N][M];
            boolean anyCheeseLeft = false;

            visited = new boolean[N][M];
            BFS();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arrayLists[i][j] == 1) {
                        anyCheeseLeft = true;
                        if (countExposedSides(i, j) >= 2) melt[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (melt[i][j]) arrayLists[i][j] = 0;
                }
            }

            if (!anyCheeseLeft) break;
            meltingTime++;
        }

        bufferedWriter.write(String.valueOf(meltingTime));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS() {
        deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (arrayLists[i][0] == 0) deque.add(new int[]{i, 0});
            if (arrayLists[i][M - 1] == 0) deque.add(new int[]{i, M - 1});
        }

        for (int i = 0; i < M; i++) {
            if (arrayLists[0][i] == 0) deque.add(new int[]{0, i});
            if (arrayLists[N - 1][i] == 0) deque.add(new int[]{N - 1, i});
        }

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();

            int x = current[0];
            int y = current[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && arrayLists[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    deque.add(new int[]{nx, ny});
                }
            }
        }
    }

    // 주어진 치즈 조각의 주변 4면을 검사하여 외부 공기와 접촉한 면의 수를 계산하고 외부 공기와 접촉한 면의 수를 반환한다.
    private static int countExposedSides(int x, int y) {
        int count = 0;

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && arrayLists[nx][ny] == 0) count++;
        }

        return count;
    }
}
