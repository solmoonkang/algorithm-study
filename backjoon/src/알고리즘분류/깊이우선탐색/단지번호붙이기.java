package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기 {

    static int N;
    static boolean[][] visited;
    static int[][] arrayLists;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int totalCount = 0;

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

        List<Integer> houseCountLists = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arrayLists[i][j] == 1 && !visited[i][j]) {
                    totalCount = 0;
                    DFS(i, j);
                    houseCountLists.add(totalCount);
                }
            }
        }

        Collections.sort(houseCountLists);
        bufferedWriter.write(String.valueOf(houseCountLists.size()));
        bufferedWriter.newLine();
        for (int count : houseCountLists) {
            bufferedWriter.write(String.valueOf(count));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static void DFS(int x, int y) {
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
