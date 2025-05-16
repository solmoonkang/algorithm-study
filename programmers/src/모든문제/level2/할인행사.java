package 모든문제.level2;

import java.io.*;
import java.util.*;

public class 할인행사 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int W = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int D = Integer.parseInt(stringTokenizer.nextToken());

        String[] wants = new String[W];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < W; i++) wants[i] = stringTokenizer.nextToken();

        int[] numbers = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        String[] discounts = new String[D];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < D; i++) discounts[i] = stringTokenizer.nextToken();

        int total = getTotalDaysSinceRegistration(wants, numbers, discounts);
        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getTotalDaysSinceRegistration(String[] wants, int[] numbers, String[] discounts) {
        int count = 0;

        Map<String, Integer> wantsCountMap = new HashMap<>();

        for (int i = 0; i < wants.length; i++) {
            wantsCountMap.put(wants[i], numbers[i]);
        }

        for (int i = 0; i < discounts.length - 9; i++) {
            Map<String, Integer> discountCountMap = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                discountCountMap.put(discounts[j], discountCountMap.getOrDefault(discounts[j], 0) + 1);
            }

            if (wantsCountMap.equals(discountCountMap)) count++;
        }

        return count;
    }

    public static int getTotalDaysSinceRegistrationWithOptimized(String[] wants, int[] numbers, String[] discounts) {
        int count = 0;

        Map<String, Integer> wantsMap = new HashMap<>();
        Map<String, Integer> windowMap = new HashMap<>();

        int N = discounts.length;

        for (int i = 0; i < wants.length; i++) wantsMap.put(wants[i], numbers[i]);

        for (int i = 0; i < 10; i++) windowMap.put(discounts[i], windowMap.getOrDefault(discounts[i], 0) + 1);
        if (windowMap.equals(wantsMap)) count++;

        for (int i = 1; i <= N - 10; i++) {
            String outItem = discounts[i - 1];
            windowMap.put(outItem, windowMap.get(outItem) - 1);
            if (windowMap.get(outItem) == 0) windowMap.remove(outItem);

            String inItem = discounts[i + 9];
            windowMap.put(inItem, windowMap.getOrDefault(inItem, 0) + 1);

            if (windowMap.equals(wantsMap)) count++;
        }

        return count;
    }
}
