package 알고리즘분류.너비우선탐색;

import java.io.*;
import java.util.*;

public class 인구이동 {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int N, L, R;
    private static boolean[][] visited;
    private static int[][] populationCountry;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        L = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());

        populationCountry = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                populationCountry[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int days = 0;
        while (true) {
            boolean moved = false;
            // 매일 초기화
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> unionList = new ArrayList<>();
                        int totalPopulation = BFS(i, j, unionList);

                        // 연합이 형성된 경우
                        if (unionList.size() > 1) {
                            moved = true;
                            int newPosition = totalPopulation / unionList.size();
                            for (int[] country : unionList) populationCountry[country[0]][country[1]] = newPosition;
                        }
                    }
                }
            }

            // 더 이상 이동이 없으면 종료
            if (!moved) break;
            days++;
        }

        bufferedWriter.write(String.valueOf(days));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS(int startX, int startY, List<int[]> unionList) {
        Deque<int[]> searchDeque = new LinkedList<>();
        searchDeque.offerLast(new int[]{startX, startY});
        visited[startX][startY] = true;

        int totalPopulation = populationCountry[startX][startY];
        unionList.add(new int[]{startX, startY});

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            for (int[] direction : directions) {
                int nx = current[0] + direction[0];
                int ny = current[1] + direction[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    int populationDifference = Math.abs(populationCountry[current[0]][current[1]] - populationCountry[nx][ny]);
                    if (populationDifference >= L && populationDifference <= R) {
                        visited[nx][ny] = true;
                        searchDeque.offerLast(new int[]{nx, ny});
                        totalPopulation += populationCountry[nx][ny];
                        unionList.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return totalPopulation;
    }
}
