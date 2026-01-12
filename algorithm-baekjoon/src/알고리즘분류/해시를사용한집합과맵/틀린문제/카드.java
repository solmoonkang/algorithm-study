package 알고리즘분류.해시를사용한집합과맵.틀린문제;

import java.io.*;
import java.util.*;

public class 카드 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int cardNumber = Integer.parseInt(bufferedReader.readLine());

        Map<Integer, Integer> cardNumberMap = new HashMap<>();

        // 현재 가장 많이 가진 카드의 개수
        int currentCardNumber = 0;
        // 현재 가장 많이 가진 카드의 숫자
        int maxCardNumber = 0;

        // 가장 많이 가진 카드의 숫자를 찾기 위한 반복문
        for (int i = 0; i < cardNumber; i++) {
            int cardNumberKey = Integer.parseInt(bufferedReader.readLine());
            int cardNumberValue = cardNumberMap.getOrDefault(cardNumberKey, 0) + 1;
            cardNumberMap.put(cardNumberKey, cardNumberValue);

            /*
             * cardNumberValue > currentCardNumber:
             * 현재 카드의 개수, cardNumberValue가 현재 가장 많이 가진 카드의 개수, currentCardNumber보다 크면,
             * 즉, 새로운 카드가 더 많이 있을 때 조건이 TRUE가 된다.
             *
             * cardNumberValue == currentCardNumber && cardNumberKey < maxCardNumber:
             * 카드 개수가 동일한 경우, 즉 현재 카드의 개수와 이전에 가장 많이 가진 카드의 개수가 같은 경우를 처리한다.
             * 이떄, 카드 숫자, cardNumberKey가 더 작은 경우를 확인한다.
             * 동일한 개수를 가진 카드가 여러 개 있을 때, 가장 작은 숫자를 가진 카드를 선택하는 역할을 한다.
             */
            if (cardNumberValue > currentCardNumber ||
                    (cardNumberValue == currentCardNumber && cardNumberKey < maxCardNumber)) {

                // 현재 카드 개수 업데이트
                currentCardNumber = cardNumberValue;
                // 현재 가장 많이 가진 카드 숫자 업데이트
                maxCardNumber = cardNumberKey;
            }
        }

        /*
         * HashMap과 정렬 사용:
         * HashMap의 엔트리를 리스트로 변환하는 과정은 O(N)의 시간 복잡도를 가진다.
         * 리스트의 정렬 시간 복잡도는 O(N logN)의 시간 복잡도를 가진다.
         * 정렬된 리스트에서 첫 번째 요소를 가져오는 것은 O(1)의 시간 복잡도를 가진다.
         *
         * 조건문을 사용한 최적화:
         * 모든 카드 숫자를 입력받으면서 동시에 카드의 개수를 세고, 가장 많이 가진 카드 숫자를 업데이트하는 과정은 O(N)의 시간 복잡도를 가진다.
         * 카드 숫자를 세는 과정에서 자동으로 가장 많이 가진 카드 숫자를 추적하므로, 별도의 정렬이 필요 없다.
         */
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(cardNumberMap.entrySet());
        entryList.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed()
                .thenComparing(Map.Entry.comparingByKey()));

        bufferedWriter.write(String.valueOf(entryList.get(0).getKey()));

        bufferedWriter.write(String.valueOf(maxCardNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
