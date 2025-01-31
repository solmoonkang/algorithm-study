package 알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final int UNREACHABLE = -1;

    private static int N, M;
    private static boolean[][][] visited;
    private static int[][] map;

    // 벽을 부수거나 세울 수 있는 조건이 주어질 때, 벽을 부수는 횟수나 세운 횟수를 상태로 관리하고 이 상태를 기반으로 탐색을 진행한다.
    // 각 노드(위치)에 대해 추가적인 정보를 저장하는 배열을 만들고, 탐색 중 벽을 부수는 경우와 부수지 않는 경우를 구분하여 상태를 전이한다.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[2][N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String mapWithWalls = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = mapWithWalls.charAt(j) - '0';
            }
        }

        int shortestWay = BFS();
        bufferedWriter.write(String.valueOf(shortestWay));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS() {
        Deque<int[]> searchDeque = new LinkedList<>();
        // 덱에 값을 넣는 것은 문제의 조건에 따라 결정되며, 탐색하는 상태(위치, 거리, 벽을 부순 횟수 등)에 따라 적절한 값을 넣어야 한다.
        searchDeque.offerLast(new int[]{0, 0, 1, 0});
        // 벽을 부수지 않은 상태에서 시작점 방문 처리
        visited[0][0][0] = true;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();

            int x = current[0];
            int y = current[1];
            int distance = current[2];
            // 벽을 부순 횟수
            int wallsBroken = current[3];

            // 목적지에 도착하면 거리 반환
            if (x == N - 1 && y == M - 1) return distance;

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    // 벽이 없는 경우
                    if (map[nx][ny] == 0 && !visited[0][nx][ny]) {
                        visited[0][nx][ny] = true;
                        searchDeque.offerLast(new int[]{nx, ny, distance + 1, wallsBroken});
                    }

                    // 벽이 있는 경우
                    else if (map[nx][ny] == 1 && !visited[1][nx][ny] && wallsBroken == 0) {
                        // 벽을 부순 상태로 방문 처리
                        visited[1][nx][ny] = true;
                        // 벽을 부순 횟수 증가
                        searchDeque.offerLast(new int[]{nx, ny, distance + 1, 1});
                    }

                    // 만약, 벽을 1개만 부술 수 있는 것이 아닌 3개를 부술 수 있다고 가정한다면
                    // visited = new boolean[4][N][M]; -> 3차원 배열 (부수지 않은 상태, 1개 부순 상태, 2개 부순 상태, 3개 부순 상태)
                    // 벽이 없는 경우, !visited[wallsBroken][nx][ny]으로 조건문을 설정한다.
                    // 벽이 있는 경우, !visited[wallsBroken + 1][nx][ny] && wallsBroken < 3으로 조건문을 설정한다.
                    // 마찬가지로 벽을 부순 상태로 방문 처리를 하는 경우 visited[wallsBroken + 1][nx][ny] = true;가 되며,
                    // 벽을 부순 횟수 증가를 위해 searchDeque.offerLast(new int[]{nx, ny, distance + 1, wallsBroken + 1});로 처리한다.
                }
            }
        }

        return UNREACHABLE;
    }
}
