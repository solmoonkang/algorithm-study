package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 패션왕신해빈 {

    // TODO: 각 의상 종류에서 선택할 수 있는 경우의 수 -> 의상 수 + 1 으로, 전체 의상 종류 * (의상 수 + 1)를 하여 전체 경우의 수를 구한다.
    //  이후, 알몸인 상태를 제외하기 위해 -1을 통해 각 의상 별 입을 수 있는 의상 종류의 경우의 수를 구한다.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());

            Map<String, Integer> costumeMap = new HashMap<>();

            for (int j = 0; j < N; j++) {
                String[] costumes = bufferedReader.readLine().split(" ");
                costumeMap.put(costumes[1], costumeMap.getOrDefault(costumes[1], 0) + 1);
            }

            int combinations = 1;
            for (int wearClothesNumberOfWay : costumeMap.values()) {
                combinations *= (wearClothesNumberOfWay + 1);
            }
            combinations--;

            stringBuilder.append(combinations).append("\n");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
