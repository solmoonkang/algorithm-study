package baekjoon.알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 전쟁_전투 {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int N, M;
    private static boolean[][] visited;
    private static char[][] battlefield;
    private static int alliesCombatPower = 0;
    private static int enemyCombatPower = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N][M];
        battlefield = new char[N][M];

        for (int i = 0; i < N; i++) {
            String alliesOrEnemy = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                battlefield[i][j] = alliesOrEnemy.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    int soldierGroup = DFS(i, j, battlefield[i][j]);
                    if (battlefield[i][j] == 'W') alliesCombatPower += soldierGroup * soldierGroup;
                    else enemyCombatPower += soldierGroup * soldierGroup;
                }
            }
        }

        bufferedWriter.write(alliesCombatPower + " " + enemyCombatPower);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int DFS(int startX, int startY, char team) {
        visited[startX][startY] = true;
        int soldierGroup = 1;

        for (int[] direction : directions) {
            int nx = startX + direction[0];
            int ny = startY + direction[1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && battlefield[nx][ny] == team) {
                soldierGroup += DFS(nx, ny, team);
            }
        }

        return soldierGroup;
    }
}
