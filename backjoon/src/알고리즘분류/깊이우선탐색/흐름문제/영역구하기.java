package 알고리즘분류.깊이우선탐색.흐름문제;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 영역구하기 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int M, N, K;
    private static boolean[][] visited;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[M][N];
        graph = new int[M][N];

        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int leftBottomX = Integer.parseInt(stringTokenizer.nextToken());
            int leftBottomY = Integer.parseInt(stringTokenizer.nextToken());
            int rightTopX = Integer.parseInt(stringTokenizer.nextToken());
            int rightTopY = Integer.parseInt(stringTokenizer.nextToken());

            // Y는 아래에서 위로 leftBottomY부터 rightTopY - 1까지
            for (int y = leftBottomY; y < rightTopY; y++) {
                // X는 왼쪽에서 오른쪽으로 leftBottomX부터 rightTopX - 1까지
                for (int x = leftBottomX; x < rightTopX; x++) {
                    // 좌측 하단 포함, 우측 상단 미포함하여 그래프를 채운다. (M은 행, N은 열)
                    graph[y][x] = 1;
                }
            }
        }

        List<Integer> rectangleAreaList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && graph[i][j] == 0) {
                    int count = DFS(i, j);
                    rectangleAreaList.add(count);
                }
            }
        }

        Collections.sort(rectangleAreaList);
        bufferedWriter.write(rectangleAreaList.size() + "\n");
        for (int width : rectangleAreaList) bufferedWriter.write(width + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int DFS(int x, int y) {
        visited[x][y] = true;
        int count = 1;

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && graph[nx][ny] == 0) {
                count += DFS(nx, ny);
            }
        }

        return count;
    }
}
