package 알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 양 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int R, C;
    private static boolean[][] visited;
    private static char[][] backyard;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[R][C];
        backyard = new char[R][C];

        for (int row = 0; row < R; row++) {
            String yardInformation = bufferedReader.readLine();
            for (int column = 0; column < C; column++) {
                backyard[row][column] = yardInformation.charAt(column);
            }
        }


        // 살아남은 양과 늑대의 총 수를 저장한다.
        int totalSheepNumber = 0, totalWolfNumber = 0;

        // 이중 반복문을 통해 마당을 순회하며, 방문하지 않았고 울타리가 아닌 칸에서 DFS를 호출한다.
        for (int row = 0; row < R; row++) {
            for (int column = 0; column < C; column++) {
                if (!visited[row][column] && backyard[row][column] != '#') {
                    int[] sheepAndWolfNumbers = DFS(row, column);
                    int sheepNumber = sheepAndWolfNumbers[0];
                    int wolfNumber = sheepAndWolfNumbers[1];

                    if (sheepNumber > wolfNumber) totalSheepNumber += sheepNumber;
                    else totalWolfNumber += wolfNumber;
                }
            }
        }

        bufferedWriter.write(totalSheepNumber + " " + totalWolfNumber);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] DFS(int startX, int startY) {
        // 기저 조건으로 현재 위치가 경계를 넘어가거나, 이미 방문했거나, 울타리인 경우, 양과 늑대 수가 0인 배열을 반환한다.
        if (startX < 0 || startX >= R || startY < 0 || startY >= C || visited[startX][startY] || backyard[startX][startY] == '#')
            return new int[]{0, 0};

        // 현재 위치를 방문 처리한다.
        visited[startX][startY] = true;

        int sheepNumber = 0, wolfNumber = 0;

        // 현재 위치에 따라 양과 늑대의 수를 카운트한다.
        if (backyard[startX][startY] == 'o') sheepNumber++;
        else if (backyard[startX][startY] == 'v') wolfNumber++;

        // 상하좌우로 DFS를 호출하여 각 호출의 결과를 받아 양과 늑대의 수를 누적한다.
        for (int[] direction : DIRECTIONS) {
            int nx = startX + direction[0];
            int ny = startY + direction[1];

            int[] sheepAndWolfNumbers = DFS(nx, ny);
            sheepNumber += sheepAndWolfNumbers[0];
            wolfNumber += sheepAndWolfNumbers[1];
        }

        return new int[]{sheepNumber, wolfNumber};
    }
}
