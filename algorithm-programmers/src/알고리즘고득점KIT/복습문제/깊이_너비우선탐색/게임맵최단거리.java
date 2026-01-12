package 알고리즘고득점KIT.복습문제.깊이_너비우선탐색;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 게임맵최단거리 {

    private static final int CANNOT_REACH_OPPOSING_TEAMS = -1;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        bufferedReader.close();

        int minSquareNumber = findMinNumberReachOpposingTeams(maps);
        bufferedWriter.write(String.valueOf(minSquareNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int findMinNumberReachOpposingTeams(int[][] maps) {
        int N = maps.length, M = maps[0].length;

        Deque<int[]> searchDeque = new ArrayDeque<>();

        int[][] distances = new int[N][M];
        distances[0][0] = 1;
        searchDeque.offerLast(new int[]{0, 0});

        while (!searchDeque.isEmpty()) {
            int[] current = searchDeque.pollFirst();
            int x = current[0];
            int y = current[1];

            if (x == N - 1 && y == M - 1) return distances[x][y];

            for (int[] direction : DIRECTIONS) {
                int dx = x + direction[0];
                int dy = y + direction[1];

                if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
                    if (maps[dx][dy] == 1 && distances[dx][dy] == 0) {
                        distances[dx][dy] = distances[x][y] + 1;
                        searchDeque.offerLast(new int[]{dx, dy});
                    }
                }
            }
        }

        return CANNOT_REACH_OPPOSING_TEAMS;
    }
}
