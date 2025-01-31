package 알고리즘분류.브루트포스알고리즘;

import java.io.*;
import java.util.*;

public class 연구소 {

    // TODO: 브루트포스와 DFS를 함께 활용하여 문제를 구현해보자.

    private static int N, M;
    private static int[][] safeArea;
    private static int maxSafeAreaSize = 0;

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        safeArea = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < M; j++) {
                safeArea[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        List<int[]> emptySpaces = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (safeArea[i][j] == 0) emptySpaces.add(new int[]{i, j});
            }
        }

        buildWalls(emptySpaces, 0, 0);

        bufferedWriter.write(String.valueOf(maxSafeAreaSize));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void buildWalls(List<int[]> emptySpaces, int start, int count) {
        if (count == 3) {
            simulateVirusSpread();
            return;
        }

        for (int i = start; i < emptySpaces.size(); i++) {
            int[] wallPosition = emptySpaces.get(i);

            safeArea[wallPosition[0]][wallPosition[1]] = 1;
            buildWalls(emptySpaces, i + 1, count + 1);
            safeArea[wallPosition[0]][wallPosition[1]] = 0;
        }
    }

    private static void simulateVirusSpread() {
        int[][] tempSafeArea = new int[N][M];

        for (int i = 0; i < N; i++) {
            tempSafeArea[i] = safeArea[i].clone();
        }

        Deque<int[]> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (safeArea[i][j] == 2) {
                    deque.offerLast(new int[]{i, j});
                }
            }
        }

        while (!deque.isEmpty()) {
            int[] current = deque.pollLast();

            for (int[] direction : directions) {
                int nx = current[0] + direction[0];
                int ny = current[1] + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (safeArea[nx][ny] == 0) {
                        tempSafeArea[nx][ny] = 2;
                        deque.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }

        calculateSafeArea(tempSafeArea);
    }

    private static void calculateSafeArea(int[][] tempSafeArea) {
        int safeAreaSize = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempSafeArea[i][j] == 0) safeAreaSize++;
            }
        }

        maxSafeAreaSize = Math.max(maxSafeAreaSize, safeAreaSize);
    }
}
