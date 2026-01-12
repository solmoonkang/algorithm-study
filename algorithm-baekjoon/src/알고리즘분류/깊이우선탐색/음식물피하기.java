package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 음식물피하기 {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int N, M, K;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        int[][] foodWastePositions = new int[K][2];
        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            // 입력받은 좌표는 1-indexed이므로 0-indexed로 변환하기 위해 1을 빼준다.
            foodWastePositions[i][0] = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            foodWastePositions[i][1] = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        }

        visited = new boolean[N][M];
        int largestWasteSize = 0;

        // 각 음식물 쓰레기의 위치에 대해 DFS를 수행하며, 방문하지 않은 경우에만 DFS를 호출한다. DFS의 결과로 반환된 크기를 저장하여 업데이트한다.
        for (int i = 0; i < K; i++) {
            int R = foodWastePositions[i][0];
            int C = foodWastePositions[i][1];
            if (!visited[R][C]) {
                int currentWasteSize = DFS(R, C, foodWastePositions);
                largestWasteSize = Math.max(largestWasteSize, currentWasteSize);
            }
        }

        bufferedWriter.write(String.valueOf(largestWasteSize));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int DFS(int row, int col, int[][] foodWastePositions) {
        // 현재 위치를 방문 처리한 후, 연결된 음식물 쓰레기의 크기를 계산한다.
        visited[row][col] = true;

        // 상하좌우로 움직이며, 범위 내에 있고 방문하지 않았으며 음식물 쓰레기인 경우에만 재귀적으로 DFS를 호출한다.
        int size = 1;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isInBounds(newRow, newCol) && !visited[newRow][newCol] && isFoodWaste(newRow, newCol, foodWastePositions)) {
                size += DFS(newRow, newCol, foodWastePositions);
            }
        }

        return size;
    }

    // 주어진 좌표가 통로의 범위 내에 있는지를 확인한다.
    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }

    // 주어진 좌표가 음식물 쓰레기 위치인지 확인한다. foodWastePositions 배열을 순회하며 비교한다.
    private static boolean isFoodWaste(int row, int col, int[][] foodWastePositions) {
        for (int[] position : foodWastePositions) {
            if (position[0] == row && position[1] == col) return true;
        }

        return false;
    }
}
