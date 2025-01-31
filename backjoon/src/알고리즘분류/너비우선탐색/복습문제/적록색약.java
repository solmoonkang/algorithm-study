package 알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 적록색약 {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N;
    private static boolean[][] visited;
    private static int[][] RGB;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N][N];
        RGB = new int[N][N];

        for (int i = 0; i < N; i++) {
            String colors = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                if (colors.charAt(j) == 'R') RGB[i][j] = 1;
                else if (colors.charAt(j) == 'G') RGB[i][j] = 2;
                else if (colors.charAt(j) == 'B') RGB[i][j] = 3;
            }
        }

        int notColorBlindCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    BFS(i, j, false);
                    notColorBlindCount++;
                }
            }
        }

        visited = new boolean[N][N];

        int colorBlindCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    BFS(i, j, true);
                    colorBlindCount++;
                }
            }
        }

        bufferedWriter.write(notColorBlindCount + " " + colorBlindCount);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void BFS(int startX, int startY, boolean isColorBlind) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{startX, startY});
        visited[startX][startY] = true;

        // BFS 탐색 중 현재 위치의 색상을 나타낸다.
        int currentColor = RGB[startX][startY];

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            for (int[] direction : directions) {
                int nx = current[0] + direction[0];
                int ny = current[1] + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    // BFS가 탐색하는 현재 위치의 상하좌우의 이웃 색상을 나타낸다.
                    int neighborColor = RGB[nx][ny];

                    // 적록색약의 경우
                    if (isColorBlind) {
                        // 현재 색이 빨간색(1) 또는 초록색(2)인 경우를 체크한다. 적록색약은 이를 구분하지 못하므로, 두 색을 동일하게 처리한다.
                        if (currentColor == 1 || currentColor == 2) {
                            // 이웃 색이 빨간색(1) 또는 초록색(2)인 경우를 체크한다. 만약 현재 색이 빨간색이나 초록색이라면, 이웃 색이 빨간색이거나 초록색이라면 같은 색으로 간주하고 BFS를 계속 진행한다.
                            if (neighborColor == 1 || neighborColor == 2) {
                                visited[nx][ny] = true;
                                searchDeque.offerLast(new int[]{nx, ny});
                            }
                        // 현재 색이 빨간색이나 초록색이 아닌 경우(즉, 파란색일 경우)에는 현재 색과 이웃 색이 같다면 BFS를 계속 진행한다.
                        } else {
                            if (currentColor == neighborColor) {
                                visited[nx][ny] = true;
                                searchDeque.offerLast(new int[]{nx, ny});
                            }
                        }
                    // 적록색약이 아닐 경우
                    } else {
                        if (currentColor == neighborColor) {
                            visited[nx][ny] = true;
                            searchDeque.offerLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}
