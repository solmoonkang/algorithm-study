package baekjoon.알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 내리막길 {

    // TODO: DFS 메서드 내에서 도착점 (M - 1, N - 1)에 도달했을 때 H를 증가시킨다.
    // TODO: 인접한 지점의 높이를 비교할 때 현재 위치의 높이와 비교한다.
    // TODO: DFS 방식만으로 구현할 경우, 중복 탐색과 재귀 호출로 인해 스택 오버플로우가 발생할 수 있다.

    // TODO: 메모이제이션으로 각 위치에서 경로의 수를 저장하고, 탐색 시작 전 높이 기준으로 정렬을 통해 이를 해결할 수 있다.

    private static int M, N;
    private static int[][] arrayLists;
    private static int[][] dynamicArray;

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());

        arrayLists = new int[M][N];
        dynamicArray = new int[M][N];

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                arrayLists[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                dynamicArray[i][j] = -1;
            }
        }

        int H = DFS(0, 0);
        bufferedWriter.write(String.valueOf(H));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int DFS(int x, int y) {
        if (x == M - 1 && y == N - 1) return 1;
        if (dynamicArray[x][y] != -1) return dynamicArray[x][y];

        dynamicArray[x][y] = 0;

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (arrayLists[nx][ny] < arrayLists[x][y]) dynamicArray[x][y] += DFS(nx, ny);
            }
        }

        return dynamicArray[x][y];
    }
}
