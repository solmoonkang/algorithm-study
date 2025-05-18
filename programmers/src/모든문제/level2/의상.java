package 모든문제.level2;

import java.io.*;
import java.util.*;

public class 의상 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        String[][] clothes = new String[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            clothes[i][0] = stringTokenizer.nextToken();
            clothes[i][1] = stringTokenizer.nextToken();
        }

        int combination = generateClothesCombination(clothes);
        bufferedWriter.write(String.valueOf(combination));
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 예를 들어, 모자 2개와 상의 1개가 있다고 가정한다면, 다음과 같은 조합을 생각할 수 있다.
     *  - 아무것도 안 입음, 모자 A만, 모자 B만, 상의만, 모자 A + 상의, 모자 B + 상의로 총 6가지의 조합이 생성된다.
     *  - 하지만 아무것도 안 입은 경우는 제외해야 하므로 6 - 1로 총 5가지의 조합이 생성된다.
     * 이를 정리하면,
     *  - 모자 2개: 모자 2개 + 안 입기 -> 3가지,
     *  - 상의 1개: 상의 1개 + 안 입기 -> 2가지
     * 공식으로 정리하면, *= (각 종류별 개수 + 1)를 해주고 마지막에 아무것도 안 입은 경우 1을 빼주면 -> (2 + 1) * (1 + 1) - 1로 총 5가지가 된다.
     */
    private static int generateClothesCombination(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] cloth : clothes) {
            clothesMap.put(cloth[1], clothesMap.getOrDefault(cloth[1], 0) + 1);
        }

        int combination = 1;
        for (Map.Entry<String, Integer> entry : clothesMap.entrySet()) {
            combination *= entry.getValue() + 1;
        }

        return combination - 1;
    }
}
