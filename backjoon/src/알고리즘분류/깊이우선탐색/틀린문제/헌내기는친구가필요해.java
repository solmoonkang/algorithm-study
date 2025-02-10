package 알고리즘분류.깊이우선탐색.틀린문제;

import java.io.*;
import java.util.StringTokenizer;

public class 헌내기는친구가필요해 {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final String HAVE_NOT_MET_ANYONE = "TT";

    private static int N, M;
    private static boolean[][] visited;
    private static char[][] universityCampus;
    private static int metPersonNumber = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N][M];
        universityCampus = new char[N][M];

        int startX = -1, startY = -1;

        for (int i = 0; i < N; i++) {
            String campusInformation = bufferedReader.readLine();

            for (int j = 0; j < M; j++) {
                universityCampus[i][j] = campusInformation.charAt(j);
                if (universityCampus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        DFS(startX, startY);
        bufferedWriter.write(metPersonNumber == 0 ? HAVE_NOT_MET_ANYONE : String.valueOf(metPersonNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        if (universityCampus[x][y] == 'P') metPersonNumber++;

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && universityCampus[nx][ny] != 'X') {
                DFS(nx, ny);
            }
        }
    }
}
