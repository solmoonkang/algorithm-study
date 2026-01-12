package 알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final Deque<int[]> deque = new LinkedList<>();
    private static final int NOT_POSSIBLE = -1;

    private static int N, M;
    private static int[][][] visited;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];
        visited = new int[N][M][2];     // 0: 벽을 부수지 않음, 1: 벽을 부숨
        for (int i = 0; i < N; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j) - '0';
                visited[i][j][0] = visited[i][j][1] = -1;
            }
        }

        int shortestDistance = BFS(0, 0);
        bufferedWriter.write(String.valueOf(shortestDistance));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int startX, int startY) {
        deque.add(new int[]{startX, startY, 0, 0});
        visited[startX][startY][0] = 0;

        while (!deque.isEmpty()) {
            int[] currentPosition = deque.pollFirst();

            int x = currentPosition[0];
            int y = currentPosition[1];
            int distance = currentPosition[2];
            int broken = currentPosition[3];

            // 도착지에 도달한 경우 최단 거리를 반환
            if (x == N - 1 && y == M - 1) return distance + 1;

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0 && visited[nx][ny][broken] == -1) {                        // 이동할 수 있는 곳
                        visited[nx][ny][broken] = distance + 1;                                     // 방문 처리
                        deque.add(new int[]{nx, ny, distance + 1, broken});
                    } else if (map[nx][ny] == 1 && broken == 0 && visited[nx][ny][1] == -1) {       // 벽을 부수고 이동
                        visited[nx][ny][1] = distance + 1;                                          // 방문 처리
                        deque.add(new int[]{nx, ny, distance + 1, 1});                              // 벽을 부순 횟수 증가
                    }
                }
            }
        }

        return NOT_POSSIBLE;
    }
}
