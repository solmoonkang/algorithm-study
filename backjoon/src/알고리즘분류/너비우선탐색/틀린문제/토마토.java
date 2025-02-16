package 알고리즘분류.너비우선탐색.틀린문제;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 토마토 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int width, height;
    private static int[][] tomatoBox;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        width = Integer.parseInt(stringTokenizer.nextToken());
        height = Integer.parseInt(stringTokenizer.nextToken());

        tomatoBox = new int[height][width];

        for (int i = 0; i < height; i++) {
            String[] tomatoInformation = bufferedReader.readLine().trim().split(" ");
            for (int j = 0; j < width; j++) {
                tomatoBox[i][j] = Integer.parseInt(tomatoInformation[j]);
            }
        }

        int currentDate = BFS();
        bufferedWriter.write(String.valueOf(currentDate));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int BFS() {
        Deque<int[]> searchDeque = new LinkedList<>();

        int currentDate = 0;
        int totalTomatoes = 0;
        int ripeTomatoes = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (tomatoBox[i][j] == 1) {
                    searchDeque.offerLast(new int[]{i, j});
                    ripeTomatoes++;
                }

                if (tomatoBox[i][j] != -1) {
                    totalTomatoes++;
                }
            }
        }

        while (!searchDeque.isEmpty()) {
            int size = searchDeque.size();

            for (int i = 0; i < size; i++) {
                int[] current = searchDeque.pollFirst();

                for (int[] direction : DIRECTIONS) {
                    int nx = current[0] + direction[0];
                    int ny = current[1] + direction[1];

                    if (nx >= 0 && nx < height && ny >= 0 && ny < width && tomatoBox[nx][ny] == 0) {
                        tomatoBox[nx][ny] = 1;
                        ripeTomatoes++;
                        searchDeque.offerLast(new int[]{nx, ny});
                    }
                }
            }

            currentDate++;
        }

        return ripeTomatoes < totalTomatoes ? -1 : currentDate - 1;
    }
}
