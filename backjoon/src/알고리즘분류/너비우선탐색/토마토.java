package 알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 토마토 {

    private static int M, N;
    private static int[][] arrayLists;

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());

        arrayLists = new int[N][M];
        Deque<int[]> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < M; j++) {
                arrayLists[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (arrayLists[i][j] == 1) deque.offerLast(new int[]{i, j});
            }
        }

        int days = BFS(deque);
        bufferedWriter.write(String.valueOf(days));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(Deque<int[]> deque) {
        int days = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int[] current = deque.pollFirst();
                int x = current[0];
                int y = current[1];

                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && arrayLists[nx][ny] == 0) {
                        arrayLists[nx][ny] = 1;
                        deque.offerLast(new int[]{nx, ny});
                    }
                }
            }

            days++;
        }

        for (int[] row : arrayLists) {
            for (int value : row) {
                if (value == 0) return -1;
            }
        }

        return days - 1;
    }
}
