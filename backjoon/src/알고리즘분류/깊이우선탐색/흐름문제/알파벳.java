package 알고리즘분류.깊이우선탐색.흐름문제;

import java.io.*;
import java.util.StringTokenizer;

public class 알파벳 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int R, C;
    private static boolean[] visited = new boolean[26];
    private static char[][] graph;
    private static int maxMovement = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        graph = new char[R][C];

        for (int i = 0; i < R; i++) {
            String alphabets = bufferedReader.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = alphabets.charAt(j);
            }
        }

        visited[graph[0][0] - 'A'] = true;
        DFS(0, 0, 1);

        bufferedWriter.write(String.valueOf(maxMovement));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int DFS(int x, int y, int count) {
        maxMovement = Math.max(maxMovement, count);

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                int index = graph[nx][ny] - 'A';

                if (!visited[index]) {
                    visited[index] = true;
                    DFS(nx, ny, count + 1);     // 현재까지 지나온 알파벳 개수를 count로 추적한다.
                    visited[index] = false;     // 백트래킹
                }
            }
        }

        return count;
    }
}
