package 알고리즘분류.구현;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {

    private static int N, M;
    private static int[][] cityMap;
    private static List<int[]> housesList = new ArrayList<>();
    private static List<int[]> chickenHousesList = new ArrayList<>();
    private static int minChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        cityMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                cityMap[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        findLocations();
        selectChickenHouses(0, 0, new int[M][2]);

        bufferedWriter.write(String.valueOf(minChickenDistance));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 집과 치킨집의 위치를 파악하여 각각의 리스트에 추가한다.
    private static void findLocations() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cityMap[i][j] == 1) housesList.add(new int[]{i, j});
                else if (cityMap[i][j] == 2) chickenHousesList.add(new int[]{i, j});
            }
        }
    }

    // 재귀적으로 M개의 치킨집을 선택하는 메서드로, selected 배열에 현재 선택된 치킨집의 좌표를 저장한다.
    private static void selectChickenHouses(int start, int count, int[][] selected) {
        if (count == M) {
            int chickenDistance = calculateTotalChickenDistance(selected);
            minChickenDistance = Math.min(minChickenDistance, chickenDistance);
            return;
        }

        for (int i = start; i < chickenHousesList.size(); i++) {
            selected[count] = chickenHousesList.get(i);
            selectChickenHouses(i + 1, count + 1, selected);
        }
    }

    // 선택된 치킨집들에 대해 각 집의 최소 치킨 거리를 계산하여 총 거리를 반환한다.
    private static int calculateTotalChickenDistance(int[][] selected) {
        int totalDistance = 0;

        for (int[] house : housesList) {
            int houseR = house[0];
            int houseC = house[1];
            int minDistance = Integer.MAX_VALUE;

            for (int[] chickenHouse : selected) {
                int chickenHouseR = chickenHouse[0];
                int chickenHouseC = chickenHouse[1];
                int distance = Math.abs(houseR - chickenHouseR) + Math.abs(houseC - chickenHouseC);

                if (distance < minDistance) minDistance = distance;
            }

            totalDistance += minDistance;
        }

        return totalDistance;
    }
}
