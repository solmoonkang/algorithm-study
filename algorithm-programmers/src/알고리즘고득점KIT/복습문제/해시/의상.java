package 알고리즘고득점KIT.복습문제.해시;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 의상 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        String[][] clothes = new String[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                clothes[i][j] = stringTokenizer.nextToken();
            }
        }
        bufferedReader.close();

        int combinationsNumber = findCombinationsOfDifferentClothes(clothes);
        bufferedWriter.write(String.valueOf(combinationsNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int findCombinationsOfDifferentClothes(String[][] clothes) {
        Map<String, Integer> combinationsMap = new HashMap<>();

        for (String[] items : clothes) {
            combinationsMap.put(items[1], combinationsMap.getOrDefault(items[1], 0) + 1);
        }

        // Map에 저장된 모든 종류별 의상 개수를 통해 (개수 + 인 입는 경우)를 곱한다.
        int combinationsNumber = 1;
        for (int combination : combinationsMap.values()) {
            combinationsNumber *= (combination + 1);
        }

        return combinationsNumber - 1;
    }
}
