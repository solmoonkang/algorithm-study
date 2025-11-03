package 모든문제.level2.복습문제;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 할인행사 {

    private static final int WINDOW_SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        String[] wants = new String[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) wants[i] = stringTokenizer.nextToken();

        int[] numbers = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        String[] discounts = new String[M];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) discounts[i] = stringTokenizer.nextToken();
        bufferedReader.close();

        int discountPeriod = getValidDiscountPeriodLength(wants, numbers, discounts);
        bufferedWriter.write(String.valueOf(discountPeriod));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int getValidDiscountPeriodLength(String[] wants, int[] numbers, String[] discounts) {
        Map<String, Integer> requiredCountsMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            requiredCountsMap.put(wants[i], numbers[i]);
        }

        // 첫 번째 윈도우 (인덱스 0 ~ 9) 초기화
        Map<String, Integer> currentDiscountCountsMap = new HashMap<>();
        for (int i = 0; i < WINDOW_SIZE; i++) {
            currentDiscountCountsMap.put(discounts[i], currentDiscountCountsMap.getOrDefault(discounts[i], 0) + 1);
        }

        // 초기 윈도우 검사
        int count = 0;
        if (isMapEqual(requiredCountsMap, currentDiscountCountsMap)) count++;

        // 슬라이딩 루프로 인덱스 1부터 시작하며, 루프는 discounts.length - WINDOW_SIZE까지 돌아야 inIndex가 배열 범위 안에 들어온다.
        for (int i = 1; i <= discounts.length - WINDOW_SIZE; i++) {
            // OUT: 윈도우에서 빠져나가는 품목 (i-1)
            String outItem = discounts[i - 1];
            currentDiscountCountsMap.put(outItem, currentDiscountCountsMap.get(outItem) - 1);

            // IN: 윈도우에 새로 들어오는 품목 (i + WINDOW_SIZE - 1)
            String inItem = discounts[i + WINDOW_SIZE - 1];
            currentDiscountCountsMap.put(inItem, currentDiscountCountsMap.getOrDefault(inItem, 0) + 1);

            if (isMapEqual(requiredCountsMap, currentDiscountCountsMap)) count++;
        }

        return count;
    }

    private static boolean isMapEqual(Map<String, Integer> required, Map<String, Integer> current) {
        // KEY의 개수가 다르면 바로 false를 반환한다.
        if (required.size() != current.size()) return false;

        // 모든 필수 품목에 대해 수량이 정확히 일치하는지 확인한다.
        for (String item : required.keySet()) {
            int requiredCount = required.get(item);
            int currentCount = current.getOrDefault(item, 0);
            if (requiredCount != currentCount) return false;
        }

        // 현재 Map에 불필요한 다른 품목이 껴있더라도, 필수 품목의 수량이 만족되면 true를 반환한다.
        return true;
    }
}
