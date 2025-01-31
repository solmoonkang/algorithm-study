package 알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.*;

public class 영역구하기 {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int M, N, K;
    private static boolean[][] visited;
    private static int[][] arrayLists;

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
            int leftX = Integer.parseInt(stringTokenizer.nextToken());
            int leftY = Integer.parseInt(stringTokenizer.nextToken());
            int rightX = Integer.parseInt(stringTokenizer.nextToken());
            int rightY = Integer.parseInt(stringTokenizer.nextToken());

            for (int row = leftY; row < rightY; row++) {
                for (int column = leftX; column < rightX; column++) {
                    arrayLists[row][column] = 1;
                }
            }
        }

        List<Integer> regionAreaList = new ArrayList<>();

        for (int row = 0; row < M; row++) {
            for (int column = 0; column < N; column++) {
                if (!visited[row][column] && arrayLists[row][column] == 0) {
                    int areaSize = BFS(row, column);
                    regionAreaList.add(areaSize);
                }
            }
        }

        Collections.sort(regionAreaList);
        bufferedWriter.write(regionAreaList.size() + "\n");
        for (int area : regionAreaList) bufferedWriter.write(area + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int startX, int startY) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int areaSize = 0;
        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            areaSize++;

            int x = current[0];
            int y = current[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && arrayLists[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    searchDeque.add(new int[]{nx, ny});
                }
            }
        }

        return areaSize;
    }
}
