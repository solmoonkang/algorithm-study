package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 영역구하기 {

    private static int M, N, K;
    private static boolean[][] visited;
    private static int[][] arrayLists;

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[M][N];
        arrayLists = new int[M][N];

        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int bottomLeftX = Integer.parseInt(stringTokenizer.nextToken());
            int bottomLeftY = Integer.parseInt(stringTokenizer.nextToken());
            int topRightX = Integer.parseInt(stringTokenizer.nextToken());
            int topRightY = Integer.parseInt(stringTokenizer.nextToken());

            for (int row = bottomLeftY; row < topRightY; row++) {
                for (int column = bottomLeftX; column < topRightX; column++) {
                    arrayLists[row][column] = 1;
                }
            }
        }

        List<Integer> areaLists = new ArrayList<>();


        for (int row = 0; row < M; row++) {
            for (int column = 0; column < N; column++) {
                if (!visited[row][column] && arrayLists[row][column] == 0) {
                    int areaCount = DFS(row, column);
                    areaLists.add(areaCount);
                }
            }
        }

        bufferedWriter.write(areaLists.size() + "\n");

        Collections.sort(areaLists);
        for (int area : areaLists) {
            bufferedWriter.write(area + " ");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int DFS(int x, int y) {
        visited[x][y] = true;
        int areaCount = 1;

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (arrayLists[nx][ny] == 0 && !visited[nx][ny]) {
                    areaCount += DFS(nx, ny);
                }
            }
        }

        return areaCount;
    }
}
