package 알고리즘분류.너비우선탐색.복습문제;

import java.io.*;
import java.util.*;

public class 단지번호붙이기 {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final List<Integer> housingComplexList = new ArrayList<>();

    private static int N;
    private static boolean[][] visited;
    private static int[][] housingComplex;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[N][N];
        housingComplex = new int[N][N];
        for (int i = 0; i < N; i++) {
            String community = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                housingComplex[i][j] = community.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && housingComplex[i][j] == 1) {
                    // 모든 집에 대해 BFS를 호출할 수 있도록 연결된 단지를 모두 탐색하도록 한다.
                    int count = BFS(i, j);
                    housingComplexList.add(count);
                }
            }
        }

        Collections.sort(housingComplexList);
        bufferedWriter.write(housingComplexList.size() + "\n");
        for (int complex : housingComplexList) bufferedWriter.write(complex + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int startX, int startY) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{startX, startY});
        visited[startX][startY] = true;

        int count = 0;
        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();

            int x = current[0];
            int y = current[1];

            count++;

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && housingComplex[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    searchDeque.offerLast(new int[]{nx, ny});
                }
            }
        }

        return count;
    }
}
