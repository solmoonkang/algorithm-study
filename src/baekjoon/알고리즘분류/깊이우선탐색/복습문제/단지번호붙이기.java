package baekjoon.알고리즘분류.깊이우선탐색.복습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기 {

    private static int N;
    private static boolean[][] visited;
    private static int[][] arrayLists;
    private static int totalCount = 0;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N][N];
        arrayLists = new int[N][N];

        for (int i = 0; i < N; i++) {
            String house = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                arrayLists[i][j] = house.charAt(j) - '0';
            }
        }

        List<Integer> houseCountsList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arrayLists[i][j] == 1 && !visited[i][j]) {
                    totalCount = 0;
                    DFS(i, j);
                    houseCountsList.add(totalCount);
                }
            }
        }

        Collections.sort(houseCountsList);
        bufferedWriter.write(houseCountsList.size() + "\n");

        for (int count : houseCountsList) {
            bufferedWriter.write(count + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;
        totalCount++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (arrayLists[nx][ny] == 1 && !visited[nx][ny]) DFS(nx, ny);
            }
        }
    }
}
