package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.StringTokenizer;

public class 전쟁_전투 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int battleFieldWidth, battleFieldHeight;
    private static boolean[][] visited;
    private static char[][] soldiersClothesColor;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        battleFieldWidth = Integer.parseInt(stringTokenizer.nextToken());
        battleFieldHeight = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[battleFieldWidth][battleFieldHeight];
        soldiersClothesColor = new char[battleFieldWidth][battleFieldHeight];

        for (int i = 0; i < battleFieldWidth; i++) {
            String clothes = bufferedReader.readLine();
            for (int j = 0; j < battleFieldHeight; j++) {
                soldiersClothesColor[i][j] = clothes.charAt(j);
            }
        }

        int friendlySolider = 0;
        int enemySolider = 0;

        for (int i = 0; i < battleFieldWidth; i++) {
            for (int j = 0; j < battleFieldHeight; j++) {
                if (!visited[i][j]) {
                    int groupSize = DFS(i, j, soldiersClothesColor[i][j]);

                    if (soldiersClothesColor[i][j] == 'W') friendlySolider += groupSize * groupSize;
                    else enemySolider += groupSize * groupSize;
                }
            }
        }

        bufferedWriter.write(friendlySolider + " " + enemySolider);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int DFS(int startX, int startY, char color) {
        visited[startX][startY] = true;

        // 현재 탐색 중인 병사 자신을 카운트하기 위해 0이 아닌 1로 초기화한다.
        int count = 1;

        for (int[] direction : DIRECTIONS) {
            int nx = startX + direction[0];
            int ny = startY + direction[1];

            if (nx >= 0 && nx < battleFieldWidth && ny >= 0 && ny < battleFieldHeight && !visited[nx][ny]) {
                if (soldiersClothesColor[nx][ny] == color) count += DFS(nx, ny, color);
            }
        }

        return count;
    }
}
