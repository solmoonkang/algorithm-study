package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 인구이동 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N, L, R;
    private static int[][] A;

    // 해당 경우에는 DFS와 BFS 모두 적합하다고 생각된다: 인접한 나라를 탐색하는 데 유용하며, 연합을 형성하고 인구를 재분배하는 과정에서 같은 방식으로 동작할 수 있다.
    // 시간 복잡도:
    // 1. 탐색 시간: 각 칸을 최대 한 번만 방문하므로 O(N^2)이다. 여기서 N은 땅의 크기이다.
    // 2. 인구 이동: 연합을 구성한 후에 인구를 재분배하는 과정도 O(N^2)로, 전체적으로 한 번의 인구 이동 과정에 대해 O(N^2)이다.
    // 따라서 최악의 경우 2,000일 동안 반복할 수 있으므로 전체 시간 복잡도는 O(2,000 * N^2)가 된다.

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        L = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int days = 0;
        // 인구 이동이 발생했는지를 나타내며, 첫 번째 반복에서 인구 이동을 확인하기 위해 true로 초기화한다.
        boolean populationMoved = true;

        while (populationMoved) {
            // 반복에서 인구 이동이 발생하지 않았음을 가정하는 것으로 이후 과정에서 인구 이동이 발생하면 다시 true로 설정한다.
            populationMoved = false;
            // 매일 새로운 인구 이동을 확인하기 위해서 이전 날의 방문 기록이 다음 날에 영향을 미칠 수 있는 전역변수로 선언하지 않는다.
            boolean[][] visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int[] totalPopulation = {0};
                        int[] totalCount = {0};

                        DFS(i, j, visited, totalPopulation, totalCount);

                        // totalCount[0]는 연합에 포함된 나라의 수로, 해당 값이 1보다 크다는 것은 연합이 2개 이상의 나라로 구성되어 있음을 의미한다.
                        if (totalCount[0] > 1) {
                            // 인구 이동이 발생할 수 있는 조건을 갖추었으므로 인구 이동 발생 여부를 true로 설정한다.
                            populationMoved = true;
                            // 연합을 이루는 각 칸의 인구수를 계산하기 위해 연합의 인구수 / 연합을 이룬 칸의 개수로 계산한다.
                            int newPopulation = totalPopulation[0] / totalCount[0];

                            // 모든 칸을 다시 순회하면서 visited 배열에 표시된 칸의 인구를 newPopulation으로 업데이트하여 연합에 포함된 모든 나라의 인구수를 재분배한다.
                            for (int x = 0; x < N; x++) {
                                for (int y = 0; y < N; y++) {
                                    if (visited[x][y]) {
                                        A[x][y] = newPopulation;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // 인구 이동이 발생할 때마다 며칠이 지났는지를 기록한다.
            if (populationMoved) days++;
        }

        bufferedWriter.write(String.valueOf(days));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int x, int y, boolean[][] visited, int[] totalPopulation, int[] totalCount) {
        visited[x][y] = true;
        totalPopulation[0] += A[x][y];
        totalCount[0] += 1;

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            // 인접한 칸끼리만 이동이 가능하도록
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                // 국경이 열렸는지 확인하는
                if (Math.abs(A[nx][ny] - A[x][y]) >= L && Math.abs(A[nx][ny] - A[x][y]) <= R) {
                    // 각 칸의 인구수는 연합의 인구수 / 연합을 이루고 있는 칸의 개수로 계산
                    DFS(nx, ny, visited, totalPopulation, totalCount);
                }
            }
        }
    }
}
