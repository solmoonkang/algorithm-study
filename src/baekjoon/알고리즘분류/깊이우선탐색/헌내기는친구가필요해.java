package baekjoon.알고리즘분류.깊이우선탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 헌내기는친구가필요해 {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final String NO_PERSON_MET = "TT";

    private static int N, M;
    private static boolean[][] visited;
    private static int[][] universityCampus;
    private static int personMet = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N][M];
        universityCampus = new int[N][M];
        int startX = -1, startY = -1;

        for (int i = 0; i < N; i++) {
            String campusInformation = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                char info = campusInformation.charAt(j);

                if (info == 'O') universityCampus[i][j] = 0;
                else if (info == 'X') universityCampus[i][j] = 1;
                else if (info == 'P') universityCampus[i][j] = 5;
                else if (info == 'I') {
                    universityCampus[i][j] = 9;
                    startX = i;
                    startY = j;
                }
            }
        }

        if (startX != -1) DFS(startX, startY);
        bufferedWriter.write(personMet == 0 ? NO_PERSON_MET : String.valueOf(personMet));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void DFS(int startX, int startY) {
        visited[startX][startY] = true;

        for (int[] direction : directions) {
            int nx = startX + direction[0];
            int ny = startY + direction[1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                if (universityCampus[nx][ny] == 5) {
                    personMet++;
                    visited[nx][ny] = true;
                } else if (universityCampus[nx][ny] == 0) DFS(nx, ny);
            }
        }
    }
}
