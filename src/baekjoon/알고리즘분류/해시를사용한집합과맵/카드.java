package baekjoon.알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 카드 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Map<Integer, Integer> numberCardMap = new HashMap<>();

        int currentNumberCardValue = 0;
        int maxNumberCardValue = 0;

        for (int i = 0; i < N; i++) {
            int numberCardKey = Integer.parseInt(bufferedReader.readLine());
            int numberCardValue = numberCardMap.getOrDefault(numberCardKey, 0) + 1;
            numberCardMap.put(numberCardKey, numberCardValue);

            if (numberCardValue > currentNumberCardValue || (numberCardValue == currentNumberCardValue && numberCardKey < maxNumberCardValue)) {
                currentNumberCardValue = numberCardValue;
                maxNumberCardValue = numberCardKey;
            }
        }

        bufferedWriter.write(String.valueOf(maxNumberCardValue));

        // '베스트셀러' 문제와 마찬가지로 Map의 Entry를 List로 변환하여 사용해도 되지만, 입력이 많을 경우 성능을 고려해 정렬 대신 직접 최대값을 찾는 방법이 더 효율적일 수 있다.
        // 예를 들어, 카드의 개수를 세고 최대 개수와 그에 해당하는 숫자를 찾는 방식으로 구현할 수 있다.
        // List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(numberCardMap.entrySet());
        // entryList.sort((currentNumberCardValue, nextNumberCardValue) -> {
        //     int maxNumberCardValue = Integer.compare(nextNumberCardValue.getValue(), currentNumberCardValue.getValue());
        //     if (maxNumberCardValue == 0) return currentNumberCardValue.getKey().compareTo(nextNumberCardValue.getKey());
        //     return maxNumberCardValue;
        // });

        // bufferedWriter.write(String.valueOf(entryList.get(0).getKey()));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
