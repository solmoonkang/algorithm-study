package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시 {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final List<CCTV> CCTVList = new ArrayList<>();

    private static int N, M;
    private static int[][] officeLayout;
    private static int minBlindSpotSize = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        officeLayout = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                officeLayout[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (officeLayout[i][j] >= 1 && officeLayout[i][j] <= 5)
                    CCTVList.add(new CCTV(i, j, officeLayout[i][j]));
            }
        }

        // 모든 CCTV 방향 조합을 시도한다.
        int[] directionCombinations = new int[CCTVList.size()];
        findMinimumBlindSpotArea(directionCombinations, 0);
        bufferedWriter.write(String.valueOf(minBlindSpotSize));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void findMinimumBlindSpotArea(int[] directionCombinations, int depth) {
        if (depth == CCTVList.size()) {
            // 모든 CCTV의 방향이 설정되었을 때 사각지대를 계산한다.
            int[][] tempOfficeLayout = new int[N][M];
            for (int i = 0; i < N; i++) tempOfficeLayout[i] = officeLayout[i].clone();
            markCCTV(tempOfficeLayout, directionCombinations);
            minBlindSpotSize = Math.min(minBlindSpotSize, countBlindSpotArea(tempOfficeLayout));
            return;
        }

        // CCTV의 방향을 설정한다.
        int CCTVType = CCTVList.get(depth).type;
        if (CCTVType == 1) {
            for (int direction = 0; direction < 4; direction++) {
                directionCombinations[depth] = direction;
                findMinimumBlindSpotArea(directionCombinations, depth + 1);
            }
        } else if (CCTVType == 2) {
            for (int direction = 0; direction < 4; direction++) {
                directionCombinations[depth] = direction;
                findMinimumBlindSpotArea(directionCombinations, depth + 1);
            }
        } else if (CCTVType == 3) {
            for (int direction = 0; direction < 4; direction++) {
                directionCombinations[depth] = direction;
                findMinimumBlindSpotArea(directionCombinations, depth + 1);
            }
        } else if (CCTVType == 4) {
            for (int direction = 0; direction < 4; direction++) {
                directionCombinations[depth] = direction;
                findMinimumBlindSpotArea(directionCombinations, depth + 1);
            }
        } else if (CCTVType == 5) {
            for (int direction = 0; direction < 4; direction++) {
                directionCombinations[depth] = 0;       // 5번은 항상 모든 방향을 바라보므로 0으로 설정한다.
                findMinimumBlindSpotArea(directionCombinations, depth + 1);
            }
        }
    }

    private static void markCCTV(int[][] tempOfficeLayout, int[] directionCombinations) {
        for (int i = 0; i < CCTVList.size(); i++) {
            CCTV cctv = CCTVList.get(i);
            int direction = directionCombinations[i];

            // CCTV 방향에 따라서 감시 영역을 마킹한다.
            switch (cctv.type) {
                case 1:
                    markDirection(tempOfficeLayout, cctv.x, cctv.y, direction);
                    break;
                case 2:
                    markDirection(tempOfficeLayout, cctv.x, cctv.y, direction);
                    markDirection(tempOfficeLayout, cctv.x, cctv.y, direction ^ 1);             // 반대 방향
                    break;
                case 3:
                    markDirection(tempOfficeLayout, cctv.x, cctv.y, direction);
                    markDirection(tempOfficeLayout, cctv.x, cctv.y, (direction + 1) % 4);       // 직각 방향
                    break;
                case 4:
                    markDirection(tempOfficeLayout, cctv.x, cctv.y, direction);
                    markDirection(tempOfficeLayout, cctv.x, cctv.y, (direction + 1) % 4);
                    markDirection(tempOfficeLayout, cctv.x, cctv.y, (direction + 2) % 4);
                    break;
                case 5:
                    for (int d = 0; d < 4; d++) {
                        markDirection(tempOfficeLayout, cctv.x, cctv.y, d);
                    }
                    break;
            }
        }
    }

    private static void markDirection(int[][] tempOfficeLayout, int x, int y, int direction) {
        int dx = directions[direction][0];
        int dy = directions[direction][1];

        while (true) {
            x += dx;
            y += dy;
            if (x < 0 || x >= N || y < 0 || y >= M || officeLayout[x][y] == 6) break;
            if (tempOfficeLayout[x][y] == 0) tempOfficeLayout[x][y] = -1;                       // 감시 영역 마킹
        }
    }

    private static int countBlindSpotArea(int[][] tempOfficeLayout) {
        int blindSpotSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempOfficeLayout[i][j] == 0) blindSpotSize++;
            }
        }

        return blindSpotSize;
    }

    private static class CCTV {
        int x, y;
        int type;

        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
