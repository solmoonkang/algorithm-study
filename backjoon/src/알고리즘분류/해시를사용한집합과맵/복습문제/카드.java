package 알고리즘분류.해시를사용한집합과맵.복습문제;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 카드 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Map<Integer, Integer> cardNumbersMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            cardNumbersMap.put(number, cardNumbersMap.getOrDefault(number, 0) + 1);
        }

        int maxCardNumberByStream = findMostFrequentCardNumberByStream(cardNumbersMap);
        bufferedWriter.write(String.valueOf(maxCardNumberByStream));
        bufferedWriter.newLine();

        int maxCardNumber = findMostFrequentCardNumber(cardNumbersMap);
        bufferedWriter.write(String.valueOf(maxCardNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 스트림을 사용한 정렬로 인해 런타임 에러가 발생하였다. 해당 과정은 비효율적일 수 있어 반복문을 통해 리팩토링을 진행하였다.
    private static int findMostFrequentCardNumberByStream(Map<Integer, Integer> cardNumbersMap) {
        return cardNumbersMap.entrySet().stream()
                .sorted((cardNumber1, cardNumber2) -> {
                    int compare = cardNumber2.getValue().compareTo(cardNumber1.getValue());
                    if (compare == 0) return cardNumber1.getKey().compareTo(cardNumber2.getKey());
                    return compare;
                })
                .map(Map.Entry::getKey)
                .findFirst().orElse(-1);
    }

    private static int findMostFrequentCardNumber(Map<Integer, Integer> cardNumbersMap) {
        int maxNumberCount = -1;
        int maxCardNumber = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : cardNumbersMap.entrySet()) {
            int cardNumber = entry.getKey();
            int count = entry.getValue();

            if (count > maxNumberCount || (count == maxNumberCount && cardNumber < maxCardNumber)) {
                maxNumberCount = count;
                maxCardNumber = cardNumber;
            }
        }

        return maxCardNumber;
    }
}
