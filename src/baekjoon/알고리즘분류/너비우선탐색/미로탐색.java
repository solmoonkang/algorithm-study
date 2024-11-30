package baekjoon.알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class 미로탐색 {

    private static int N, M;
    private static boolean[][] visited;
    private static int[][] arrayLists;

    private static Deque<int[]> deque = new LinkedList<>();
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arrayLists = new int[N][M];

        for (int i = 0; i < N; i++) {
            String numbers = bufferedReader.readLine();

            for (int j = 0; j < M; j++) {
                arrayLists[i][j] = numbers.charAt(j) - '0';
            }
        }

        int minNumber = BFS(0, 0);
        bufferedWriter.write(String.valueOf(minNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int startX, int startY) {
        deque.offerLast(new int[]{startX, startY});

        visited = new boolean[N][M];
        visited[startX][startY] = true;

        int minNumber = 1;

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int[] current = deque.pollFirst();
                int x = Objects.requireNonNull(current)[0];
                int y = Objects.requireNonNull(current)[1];

                if (x == N - 1 && y == M - 1) return minNumber;

                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && arrayLists[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        deque.offerLast(new int[]{nx, ny});
                    }
                }
            }

            minNumber++;
        }

        return -1;
    }
}
