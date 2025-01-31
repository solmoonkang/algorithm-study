package 알고리즘분류.깊이우선탐색.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 안전영역 {

    /**
     * 데이터 구조에 따른 배열 차원 결정
     * <p>
     * 1차원 배열
     * - 일반적으로 노드나 정점을 표현할 때 사용된다. 예를 들어, 그래프의 정점, 학생의 선택 등과 같이 1차원으로 표현할 수 있는 경우에 적합하다.
     * - 1차원 배열은 인덱스를 통해 각 요소에 접근할 수 있는 간단한 구조이다. 예를 들어, visited[i]라고 하면 i번째 학생이나 노드의 방문 여부를 확인할 수 있다.
     * <p>
     * 2차원 배열
     * - 2차원 배열은 행렬 형태의 데이터를 표현할 때 사용된다. 예를 들어, 지도의 높이 정보나 이미지 데이터를 처리할 때 사용된다.
     * - 2차원 배열은 visited[i][j]와 같은 형태로 각 위치에 대한 정보를 저장할 수 있다. 이 경우 i는 행을 j는 열을 나타낸다.
     */

    private static int N;
    private static boolean[][] visited;
    private static int[][] arrayLists;

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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

        int maxSafeAreas = 0;

        // 비가 내리는 높이에 따라 모든 경우를 조사해야 하므로, rainHeight에 대한 반복이 필요하다.
        // 비가 내리는 높이에 대해 1부터 100까지 반복하면서 각각의 경우에 대한 안전 지역을 계산해야 한다.
        for (int rainHeight = 0; rainHeight <= 100; rainHeight++) {
            // 비가 내리는 높이가 바뀔 때마다 visited 배열을 새로 초기화해야 한다.
            visited = new boolean[N][N];
            int safeAreaCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arrayLists[i][j] > rainHeight && !visited[i][j]) {
                        DFS(i, j, rainHeight);
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

    private static void DFS(int x, int y, int rainHeight) {
        visited[x][y] = true;

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            // 현재 위치의 높이가 rainHeight보다 높은 경우에만 DFS를 통해 안전 지역으로 탐색한다.
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (arrayLists[nx][ny] > rainHeight && !visited[nx][ny]) DFS(nx, ny, rainHeight);
            }
        }
    }
}
