package baekjoon.알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 미로탐색 {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N, M;
    private static boolean[][] visited;
    private static int[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N][M];
        maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            String numbers = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = numbers.charAt(j) - '0';
            }
        }

        int minMoves = BFS(0, 0);
        bufferedWriter.write(String.valueOf(minMoves));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int startX, int startY) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{startX, startY});
        visited[startX][startY] = true;

        int moves = 0;
        while (!searchDeque.isEmpty()) {
            // 현재 레벨에서 탐색해야 할 정점의 수를 의미한다. BFS는 덱에 탐색할 정점을 FIFO 방식으로 처리하므로, 현재 레벨의 모든 정점을 한 번에 처리하기 위해 다음과 같이 사용한다.
            int size = searchDeque.size();

            // 현재 탐색 중인 레벨을 처리하기 위해 다음과 같은 반복문으로 덱을 순회한다.
            // BFS는 각 정점을 탐색할 때, 먼저 현재 정점과 직접 연결된 이웃 정점들을 모두 탐색하고, 그 다음 이웃 정점의 이웃을 탐색하는 방식으로 진행된다. 이를 통해 BFS는 각 레벨(또는 깊이)에서 탐색을 수행한다.
            for (int i = 0; i < size; i++) {
                int[] current = searchDeque.pollFirst();
                int x = current[0];
                int y = current[1];

                // 현재 위치가 미로의 마지막 행과 마지막 열에 있는지를 확인하며, BFS에서 moves는 현재 탐색한 깊이를 나타내는 것으로 마지막 이동을 포함해야 한다.
                if (x == N - 1 && y == M - 1) return moves + 1;

                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && maze[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        searchDeque.offerLast(new int[]{nx, ny});
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}
