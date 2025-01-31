package 알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 적록색약 {

    private static final Deque<int[]> deque = new LinkedList<>();
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int N;
    private static boolean[][] visited;
    private static int[][] arrayLists;
    private static int seenOrHeardPerson = 0;
    private static int nonSeenOrHeardPerson = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N][N];
        arrayLists = new int[N][N];
        for (int i = 0; i < N; i++) {
            String RGB = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                if (RGB.charAt(j) == 'R') arrayLists[i][j] = 1;
                else if (RGB.charAt(j) == 'G') arrayLists[i][j] = 2;
                else if (RGB.charAt(j) == 'B') arrayLists[i][j] = 3;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    BFS(i, j, false);
                    seenOrHeardPerson++;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    BFS(i, j, true);
                    nonSeenOrHeardPerson++;
                }
            }
        }

        bufferedWriter.write(seenOrHeardPerson + " " + nonSeenOrHeardPerson);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS(int startX, int startY, boolean isColorBlind) {
        deque.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int currentColor = arrayLists[startX][startY];

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();

            int x = current[0];
            int y = current[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    int neighborColor = arrayLists[nx][ny];

                    if (isColorBlind) {
                        if (currentColor == 1 || currentColor == 2) {
                            if (neighborColor == 1 || neighborColor == 2) {
                                visited[nx][ny] = true;
                                deque.add(new int[]{nx, ny});
                            }
                        } else {
                            if (currentColor == neighborColor) {
                                visited[nx][ny] = true;
                                deque.add(new int[]{nx, ny});
                            }
                        }
                    } else {
                        if (currentColor == neighborColor) {
                            visited[nx][ny] = true;
                            deque.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}
