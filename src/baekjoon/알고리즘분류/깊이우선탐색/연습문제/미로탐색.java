package baekjoon.알고리즘분류.깊이우선탐색.연습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 미로탐색 {

    /**
     * 문제:
     * 주어진 미로에서 출발점에서 도착점까지의 경로를 찾는 문제입니다. 미로는 0과 1로 구성되어 있으며, 0은 이동할 수 있는 공간, 1은 벽입니다.
     *
     * 입력:
     * 첫 번째 줄에 미로의 크기 (N) (1 ≤ (N) ≤ 100)과 (M) (1 ≤ (M) ≤ 100)가 주어집니다.
     * 다음 (N)줄에 (M)개의 0과 1로 구성된 미로가 주어집니다.
     * 마지막 줄에 시작 좌표 (start)와 도착 좌표 (end)가 주어집니다.
     *
     * 출력:
     * 경로가 있다면 "가능"을, 없다면 "불가능"을 출력합니다.
     */

    /**
     * 입력:
     * 5 5
     * 0 1 0 0 0
     * 0 1 0 1 0
     * 0 0 0 1 0
     * 1 1 0 1 0
     * 0 0 0 0 0
     * 1 0
     * 4 4
     * <p>
     * 출력:
     * 가능
     */

    private static int N, M;
    private static boolean[][] visited;
    private static int[][] arrayLists;

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N][M];
        arrayLists = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < M; j++) {
                arrayLists[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int startX = Integer.parseInt(stringTokenizer.nextToken());
        int startY = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int endX = Integer.parseInt(stringTokenizer.nextToken());
        int endY = Integer.parseInt(stringTokenizer.nextToken());

        bufferedWriter.write(DFS(startX, startY, endX, endY) ? "가능" : "불가능");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean DFS(int x, int y, int endX, int endY) {
        if (x == endX && y == endY) return true;

        if (x < 0 || x >= N || y < 0 || y >= N || arrayLists[x][y] == 1 || visited[x][y]) return false;

        visited[x][y] = true;

        for (int[] direction : directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];

            if (DFS(nextX, nextY, endX, endY)) return true;
        }

        visited[x][y] = false;
        return false;
    }
}
