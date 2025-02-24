package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 침투 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final String IS_TRANSMITTED_INSIDE = "YES";
    private static final String IS_NOT_TRANSMITTED_INSIDE = "NO";

    private static int M, N;
    private static boolean[][] visited;
    private static char[][] fiberMaterials;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[M][N];
        fiberMaterials = new char[M][N];

        for (int i = 0; i < M; i++) {
            String electric = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                fiberMaterials[i][j] = electric.charAt(j);
            }
        }

        // 첫 번째 행의 모든 열을 검사하여 '0'인 위치에서 DFS를 시작한다. DFS가 마지막 행에 도달하면 "YES"를 반환한다.
        for (int j = 0; j < N; j++) {
            if (!visited[0][j] && fiberMaterials[0][j] == '0') {
                if (DFS(0, j)) {
                    bufferedWriter.write(IS_TRANSMITTED_INSIDE);
                    bufferedWriter.flush();
                    return;
                }
            }
        }

        bufferedWriter.write(IS_NOT_TRANSMITTED_INSIDE);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean DFS(int x, int y) {
        visited[x][y] = true;

        // 마지막 행에 도달하면 true를 반환한다.
        if (x == M - 1) return true;

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && fiberMaterials[nx][ny] == '0') {
                if (DFS(nx, ny)) return true;
            }
        }

        return false;
    }
}
