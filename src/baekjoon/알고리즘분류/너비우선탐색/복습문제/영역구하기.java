package baekjoon.알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.*;

public class 영역구하기 {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int M, N, K;
    private static boolean[][] visited;
    private static int[][] graphPaper;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[M][N];
        graphPaper = new int[M][N];

        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int leftX = Integer.parseInt(stringTokenizer.nextToken());
            int leftY = Integer.parseInt(stringTokenizer.nextToken());
            int rightX = Integer.parseInt(stringTokenizer.nextToken());
            int rightY = Integer.parseInt(stringTokenizer.nextToken());

            for (int row = leftY; row < rightY; row++) {
                for (int column = leftX; column < rightX; column++) {
                    // 배열의 y좌표가 증가할수록 아래로 내려가므로, 입력된 y좌표를 배열의 인덱스로 변환할 때 y=2는 배열에서 index=3에 해당해야 한다.
                    // 따라서 M은 배열의 총 행 수이므로, M - 1 - row를 사용하여 입력된 y좌표를 배열의 index에 맞추는 것이다.
                    graphPaper[M - 1 - row][column] = 1;
                }
            }
        }

        List<Integer> separatedRegionsList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && graphPaper[i][j] == 0) {
                    int separatedRegions = BFS(i, j);
                    separatedRegionsList.add(separatedRegions);
                }
            }
        }

        Collections.sort(separatedRegionsList);
        bufferedWriter.write(separatedRegionsList.size() + "\n");
        for (int region : separatedRegionsList) bufferedWriter.write(region + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int startX, int startY) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{startX, startY});
        visited[startX][startY] = true;

        int separatedRegions = 0;
        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            separatedRegions++;
            for (int[] direction : directions) {
                int nx = current[0] + direction[0];
                int ny = current[1] + direction[1];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && graphPaper[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    searchDeque.offerLast(new int[]{nx, ny});
                }
            }
        }

        return separatedRegions;
    }
}
