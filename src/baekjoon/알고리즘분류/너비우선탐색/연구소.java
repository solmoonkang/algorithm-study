package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.*;

public class 연구소 {

    private static final List<int[]> emptySpacesList = new ArrayList<>();
    private static final Deque<int[]> deque = new LinkedList<>();
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final int NEW_WALL_COUNT = 3;

    private static int N, M;
    private static int[][] arrayLists;
    private static int maxSafeAreaSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arrayLists = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                arrayLists[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (arrayLists[i][j] == 0) emptySpacesList.add(new int[]{i, j});
            }
        }

        BFS(0, 0);
        bufferedWriter.write(String.valueOf(maxSafeAreaSize));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS(int startIndex, int count) {
        if (count == NEW_WALL_COUNT) {
            simulateVirusSpread();
            return;
        }

        for (int i = startIndex; i < emptySpacesList.size(); i++) {
            int[] wallPosition = emptySpacesList.get(i);

            int x = wallPosition[0];
            int y = wallPosition[1];

            arrayLists[x][y] = 1;       // 벽 세우기
            BFS(i + 1, count + 1);      // 다음 빈 공간으로 진행
            arrayLists[x][y] = 0;       // 벽 제거
        }
    }

    private static void simulateVirusSpread() {
        int[][] virusSpreadMap = new int[N][M];
        for (int i = 0; i < N; i++) virusSpreadMap[i] = arrayLists[i].clone();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusSpreadMap[i][j] == 2) deque.add(new int[]{i, j});
            }
        }

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();

            int x = current[0];
            int y = current[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && virusSpreadMap[nx][ny] == 0) {
                    virusSpreadMap[nx][ny] = 2;
                    deque.add(new int[]{nx, ny});
                }
            }
        }

        int safeAreaSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusSpreadMap[i][j] == 0) safeAreaSize++;
            }
        }

        maxSafeAreaSize = Math.max(maxSafeAreaSize, safeAreaSize);
    }
}
