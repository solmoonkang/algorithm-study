package 알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 유기농배추 {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int M, N, K;
    private static boolean[][] visited;
    private static int[][] gangwonHighland;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            M = Integer.parseInt(stringTokenizer.nextToken());
            N = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());

            visited = new boolean[M][N];
            gangwonHighland = new int[M][N];

            for (int j = 0; j < K; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int X = Integer.parseInt(stringTokenizer.nextToken());
                int Y = Integer.parseInt(stringTokenizer.nextToken());

                gangwonHighland[X][Y] = 1;
            }

            int minCabbageWhiteWorm = 0;
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && gangwonHighland[j][k] == 1) {
                        BFS(j, k);
                        minCabbageWhiteWorm++;
                    }
                }
            }

            bufferedWriter.write(minCabbageWhiteWorm + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS(int startX, int startY) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();

            int x = current[0];
            int y = current[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && gangwonHighland[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    searchDeque.offerLast(new int[]{nx, ny});
                }
            }
        }
    }
}
