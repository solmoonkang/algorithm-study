package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 유기농배추 {

    private static int M, N, K;
    private static boolean[][] visited;
    private static int[][] arrayLists;

    private static final Deque<int[]> deque = new LinkedList<>();
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            M = Integer.parseInt(stringTokenizer.nextToken());
            N = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());

            arrayLists = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                int cabbageLocationX = Integer.parseInt(stringTokenizer.nextToken());
                int cabbageLocationY = Integer.parseInt(stringTokenizer.nextToken());

                arrayLists[cabbageLocationY][cabbageLocationX] = 1;
            }

            int cabbageWorm = 0;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (arrayLists[y][x] == 1 && !visited[y][x]) {
                        BFS(y, x);
                        cabbageWorm++;
                    }
                }
            }

            bufferedWriter.write(cabbageWorm + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS(int startY, int startX) {
        deque.add(new int[]{startY, startX});

        visited[startY][startX] = true;

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int[] current = deque.pollFirst();

                int x = current[1];
                int y = current[0];

                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && arrayLists[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        deque.offerLast(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
