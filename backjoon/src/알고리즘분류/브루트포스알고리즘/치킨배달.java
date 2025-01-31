package 알고리즘분류.브루트포스알고리즘;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {

    /**
     * 문제 풀이 계획
     * 1. 치킨집 조합 생성: 주어진 치킨집 중에서 최대 M개를 선택하는 모든 조합을 생성한다. 이 조합을 통해 선택된 치킨집만으로 치킨 거리를 계산할 수 있다.
     * 2. 치킨 거리 계산: 각 집에 대해 선택된 치킨집들과의 거리 계산을 통해 가장 가까운 최킨집의 거리를 찾는다.
     * 3. 최소 거리 갱신: 모든 조합을 통해 계산된 치킨 거리를 비교하여 최소값을 갱신한다.
     */

    private static int N, M;
    private static int[][] city;
    private static List<int[]> housesList = new ArrayList<>();
    private static List<int[]> chickenStoresList = new ArrayList<>();
    private static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (city[i][j] == 1) housesList.add(new int[]{i, j});
                else if (city[i][j] == 2) chickenStoresList.add(new int[]{i, j});
            }
        }

        selectChickStores(new int[M], 0, 0);
        bufferedWriter.write(String.valueOf(minDistance));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void selectChickStores(int[] selected, int start, int depth) {
        if (depth == M) {
            calculateChickDistance(selected);
            return;
        }

        for (int i = start; i < chickenStoresList.size(); i++) {
            selected[depth] = i;
            selectChickStores(selected, i + 1, depth + 1);
        }
    }

    private static void calculateChickDistance(int[] selected) {
        int totalDistance = 0;

        for (int[] houses : housesList) {
            int minDistanceForHouse = Integer.MAX_VALUE;

            for (int index : selected) {
                int[] chickenStore = chickenStoresList.get(index);
                int distance = Math.abs(houses[0] - chickenStore[0]) + Math.abs(houses[1] - chickenStore[1]);
                minDistanceForHouse = Math.min(minDistanceForHouse, distance);
            }

            totalDistance += minDistanceForHouse;
        }

        minDistance = Math.min(minDistance, totalDistance);
    }
}
