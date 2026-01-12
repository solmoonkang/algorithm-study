package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 컴백홈 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int R, C, K;
    private static boolean[][] visited;
    private static char[][] map;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[R][C];
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String mapInformation = bufferedReader.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = mapInformation.charAt(j);
            }
        }

        // 한수가 현재 위치인 왼쪽 아래 모서리를 (R-1, 0)으로 표현한다.
        // visited[R - 1][0] = true;으로 설정함으로써 한수가 이 위치를 방문했음을 표시한다.
        visited[R - 1][0] = true;
        DFS(R - 1, 0, 1);

        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int startX, int startY, int distance) {
        if (startX == 0 && startY == C - 1) {
            if (distance == K) count++;
            return;
        }

        for (int[] direction : DIRECTIONS) {
            int nx = startX + direction[0];
            int ny = startY + direction[1];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && map[nx][ny] != 'T') {
                visited[nx][ny] = true;
                DFS(nx, ny, distance + 1);
                visited[nx][ny] = false;
            }
        }
    }
}
