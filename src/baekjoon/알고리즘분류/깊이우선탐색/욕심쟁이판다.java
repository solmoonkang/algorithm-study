package baekjoon.알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 욕심쟁이판다 {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int N;
    private static int[][] bambooForest;
    private static int[][] dynamicArray;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        bambooForest = new int[N][N];
        dynamicArray = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                bambooForest[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int maxMoves = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxMoves = Math.max(maxMoves, DFS(i, j));
            }
        }

        bufferedWriter.write(String.valueOf(maxMoves));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int DFS(int x, int y) {
        // 이미 계산된 경우, 메모이제이션을 활용한다.
        if (dynamicArray[x][y] != 0) return dynamicArray[x][y];
        dynamicArray[x][y] = 1;

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            // 경계 체크 및 이동 가능 여부를 확인한다.
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && bambooForest[nx][ny] > bambooForest[x][y]) {
                // 최대 이동할 수 있는 칸 수를 업데이트한다.
                dynamicArray[x][y] = Math.max(dynamicArray[x][y], 1 + DFS(nx, ny));
            }
        }

        // 현재 위치에서 최대 이동 칸 수를 반환한다.
        return dynamicArray[x][y];
    }
}
