package baekjoon.알고리즘분류.백트래킹.복습문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {

    /**
     * 1. 백트래킹의 목적
     * - 도시의 모든 치킨집 중 최대 M개를 선택한다.
     * - 선택된 치킨집으로 도시의 치킨 거리를 계산한다.
     * 2. 핵심 아이디어
     * - 치킨집들의 좌표를 리스트로 관리한다.
     * - 백트래킹으로 M개의 치킨집 조합을 선택한다.
     * - 선택된 치킨집으로 도시의 치킨 거리를 계산한다.
     */

    private static int N, M;
    private static boolean[] visited;
    private static List<int[]> chickenShopsList = new ArrayList<>();
    private static List<int[]> housesList = new ArrayList<>();
    private static int minCityDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(stringTokenizer.nextToken());
                if (value == 1) housesList.add(new int[]{i, j});
                else if (value == 2) chickenShopsList.add(new int[]{i, j});
                map[i][j] = value;
            }
        }

        visited = new boolean[chickenShopsList.size()];
        selectChickenShops(0, 0);
        bufferedWriter.write(String.valueOf(minCityDistance));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 치킨집 좌표 리스트를 기반으로 백트래킹을 수행하여 최대 M개의 치킨집 조합을 선택한다.
    // 선택된 치킨집 조합이 완료되면, calculateCityChickenDistance 메서드를 호출하여 도시의 치킨 거리를 계산한다.
    private static void selectChickenShops(int start, int depth) {
        if (depth == M) {
            minCityDistance = Math.min(minCityDistance, calculateCityChickenDistance());
            return;
        }

        for (int i = start; i < chickenShopsList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selectChickenShops(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    // 선택된 치킨집과 각 집의 거리 중 최소값을 계산한다. 모든 집의 최소 거리를 합산하여 도시의 치킨 거리를 구한다.
    private static int calculateCityChickenDistance() {
        int totalDistance = 0;

        // 각 집을 기준으로 모든 집들을 순회한다.
        for (int[] houses : housesList) {
            int houseDistance = Integer.MAX_VALUE;

            // 그렇게 모든 치킨집을 탐색한다.
            for (int i = 0; i < chickenShopsList.size(); i++) {
                // 만약, 선택된 치킨집만
                if (visited[i]) {
                    int[] chickenShops = chickenShopsList.get(i);
                    int distance = Math.abs(houses[0] - chickenShops[0]) + Math.abs(houses[1] - chickenShops[1]);
                    // 최소 거리를 갱신한다.
                    houseDistance = Math.min(houseDistance, distance);
                }
            }

            // 그렇게 갱신된 최소 거리를 도시 치킨 거리에 합산한다.
            totalDistance += houseDistance;
        }

        return totalDistance;
    }
}
