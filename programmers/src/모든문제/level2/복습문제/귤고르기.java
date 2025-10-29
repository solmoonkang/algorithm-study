package 모든문제.level2.복습문제;

import java.io.*;
import java.util.*;

public class 귤고르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        int[] tangerines = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) tangerines[i] = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();

        int minTangerines = findMinDifferentTypesTangerines(K, tangerines);
        bufferedWriter.write(String.valueOf(minTangerines));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int findMinDifferentTypesTangerines(int K, int[] tangerines) {
        // 귤의 종류별 개수를 세기 위해 귤 전체를 각 크기별로 저장한다.
        Map<Integer, Integer> tangerinesCountMap = new HashMap<>();
        for (int tangerine : tangerines) {
            tangerinesCountMap.put(tangerine, tangerinesCountMap.getOrDefault(tangerine, 0) + 1);
        }

        // 귤의 개수를 기준으로 내림차순 정렬을 하여, 가장 많은 개수를 가진 귤의 종류부터 선택한다.
        List<Integer> tangerinesCountList = new ArrayList<>(tangerinesCountMap.values());
        tangerinesCountList.sort(Collections.reverseOrder());

        int tangerinesCount = 0;
        for (int tangerine : tangerinesCountList) {
            tangerinesCount++;
            K -= tangerine;
            if (K <= 0) break;
        }

        return tangerinesCount;
    }
}
