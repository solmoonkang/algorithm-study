package baekjoon.알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 알파벳 {

    private static int R, C;
    private static boolean[] visited;
    private static char[][] arrayLists;
    private static int maxCount = 0;

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        arrayLists = new char[R][C];

        for (int i = 0; i < R; i++) {
            String alphabet = bufferedReader.readLine();
            arrayLists[i] = alphabet.toCharArray();
        }

        visited = new boolean[26];

        DFS(0, 0, 1);

        bufferedWriter.write(String.valueOf(maxCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int x, int y, int count) {
        maxCount = Math.max(maxCount, count);
        visited[arrayLists[x][y] - 'A'] = true;

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (!visited[arrayLists[nx][ny] - 'A']) DFS(nx, ny, count + 1);
            }
        }

        visited[arrayLists[x][y] - 'A'] = false;
    }
}
