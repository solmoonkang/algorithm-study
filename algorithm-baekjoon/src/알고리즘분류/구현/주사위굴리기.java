package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 주사위굴리기 {

    private static final int TOP = 0;
    private static final int BOTTOM = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;
    private static final int EAST = 4;
    private static final int WEST = 5;
    private static final int[][] DIRECTIONS = {
            {0, 0},     // DUMMY
            {0, 1},     // 1 -> 동쪽
            {0, -1},    // 2 -> 서쪽
            {-1, 0},    // 3 -> 북쪽
            {1, 0}      // 4 -> 남쪽
    };

    private static int[] dice = new int[6];

    /**
     * 동쪽으로 굴리기: TOP←WEST, BOTTOM←EAST, EAST←TOP, WEST←BOTTOM
     */
    public static void rollEast(int[] d) {
        int top = d[TOP];
        int bottom = d[BOTTOM];
        int east = d[EAST];
        int west = d[WEST];

        d[TOP] = west;
        d[BOTTOM] = east;
        d[EAST] = top;
        d[WEST] = bottom;
        // NORTH, SOUTH 면은 변화 없음
    }

    /**
     * 서쪽으로 굴리기: TOP←EAST, BOTTOM←WEST, EAST←BOTTOM, WEST←TOP
     */
    public static void rollWest(int[] d) {
        int top = d[TOP];
        int bottom = d[BOTTOM];
        int east = d[EAST];
        int west = d[WEST];

        d[TOP] = east;
        d[BOTTOM] = west;
        d[EAST] = bottom;
        d[WEST] = top;
    }

    /**
     * 북쪽으로 굴리기: TOP←SOUTH, BOTTOM←NORTH, NORTH←TOP, SOUTH←BOTTOM
     */
    public static void rollNorth(int[] d) {
        int top = d[TOP];
        int bottom = d[BOTTOM];
        int north = d[NORTH];
        int south = d[SOUTH];

        d[TOP] = south;
        d[BOTTOM] = north;
        d[NORTH] = top;
        d[SOUTH] = bottom;
    }

    /**
     * 남쪽으로 굴리기: TOP←NORTH, BOTTOM←SOUTH, NORTH←BOTTOM, SOUTH←TOP
     */
    public static void rollSouth(int[] d) {
        int top = d[TOP];
        int bottom = d[BOTTOM];
        int north = d[NORTH];
        int south = d[SOUTH];

        d[TOP] = north;
        d[BOTTOM] = south;
        d[NORTH] = bottom;
        d[SOUTH] = top;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int X = Integer.parseInt(stringTokenizer.nextToken());
        int Y = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[] commands = new int[K];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < K; i++) {
            commands[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        // 주사위 초기 위치
        int x = X, y = Y;

        // 각 명령 처리 루프
        for (int command : commands) {
            // 1. 다음 좌표 계산
            int nx = x + DIRECTIONS[command][0];
            int ny = y + DIRECTIONS[command][1];

            // 2. 지도 범위 벗어나면 명령 무시
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            // 3. 주사위 굴리기
            switch (command) {
                case 1 -> rollEast(dice);
                case 2 -> rollWest(dice);
                case 3 -> rollNorth(dice);
                case 4 -> rollSouth(dice);
            }

            // 4. 칸 <-> 주사위 바닥면 교환
            // 칸이 0이면 주사위 바닥값을 지도에 복사
            if (map[nx][ny] == 0) map[nx][ny] = dice[BOTTOM];
            else {
                // 칸이 0이 아니면 칸 값을 주사위 바닥에 복사하고 칸은 0으로
                dice[BOTTOM] = map[nx][ny];
                map[nx][ny] = 0;
            }

            // 5. 주사위 윗 면 값 출력
            bufferedWriter.write(dice[TOP] + "\n");

            x = nx;
            y = ny;
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
