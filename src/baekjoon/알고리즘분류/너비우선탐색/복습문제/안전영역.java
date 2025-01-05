package baekjoon.알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 안전영역 {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N;
    private static boolean[][] visited;
    private static int[][] rainfallDuringMonsoonSeason;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        rainfallDuringMonsoonSeason = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                rainfallDuringMonsoonSeason[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int maxSafeArea = 0;
        // rainHeight는 비의 양을 나타내는 변수로, 이 값에 따라 물에 잠기지 않는 안전한 영역을 정의한다.
        // 문제의 조건은 특정 높이 이하의 모든 지점은 물에 잠긴다고 가정한다. 따라서, rainHeight는 이 특정 높이를 의미하며, 이 값에 따라 물에 잠기지 않는 지점이 결정된다.
        // 또한, 비가 오지 않을 수도 있으므로 물의 양은 0부터 높이가 100이하인 모든 지점이 물에 잠기는 경우를 고려해야 한다.
        for (int rainHeight = 0; rainHeight <= 100; rainHeight++) {
            visited = new boolean[N][N];
            int safeAreaCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && rainfallDuringMonsoonSeason[i][j] > rainHeight) {
                        BFS(i, j, rainHeight);
                        safeAreaCount++;
                    }
                }
            }

            maxSafeArea = Math.max(maxSafeArea, safeAreaCount);
        }

        bufferedWriter.write(String.valueOf(maxSafeArea));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS(int startX, int startY, int rainHeight) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            for (int[] direction : directions) {
                int nx = current[0] + direction[0];
                int ny = current[1] + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && rainfallDuringMonsoonSeason[nx][ny] > rainHeight) {
                    visited[nx][ny] = true;
                    searchDeque.offerLast(new int[]{nx, ny});
                }
            }
        }
    }
}
