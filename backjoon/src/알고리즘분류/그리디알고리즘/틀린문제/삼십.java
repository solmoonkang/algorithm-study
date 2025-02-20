package 알고리즘분류.그리디알고리즘.틀린문제;

import java.io.*;
import java.util.*;

public class 삼십 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = bufferedReader.readLine();

        int largestNumber = getLargestNumberMultipleThirtyToCombination(N);
        bufferedWriter.write(largestNumber + "\n");

        bufferedWriter.write(getLargestNumberMultipleThirtyGreedy(N));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String getLargestNumberMultipleThirtyGreedy(String targetNumber) {
        int[] digitCount = new int[10];
        int sum = 0;
        boolean hasZero = false;

        for (char c : targetNumber.toCharArray()) {
            int digit = c - '0';
            // 나중에 각 숫자를 얼마나 사용할 수 있는지 쉽게 알 수 있다. 특히, 조합이나 순열을 생성할 때 유용하다.
            digitCount[digit]++;
            sum += digit;

            if (digit == 0) hasZero = true;
        }

        // 30의 배수는 각 자리의 숫자 합이 3의 배수이다.
        if (!hasZero || sum % 3 != 0) return "-1";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (digitCount[i] > 0) {
                stringBuilder.append(i);
                digitCount[i]--;
            }
        }

        return stringBuilder.toString();
    }

    private static int getLargestNumberMultipleThirtyToCombination(String targetNumber) {
        Set<Integer> combinations = new HashSet<>();
        generateCombinations("", targetNumber, combinations);

        List<Integer> multipleThirty = new ArrayList<>();

        for (int combination : combinations) {
            if (combination % 30 == 0) multipleThirty.add(combination);
        }

        multipleThirty.sort(Collections.reverseOrder());
        return multipleThirty.isEmpty() ? -1 : multipleThirty.get(0);
    }

    private static void generateCombinations(String prefix, String remaining, Set<Integer> combinations) {
        if (remaining.isEmpty()) {
            combinations.add(Integer.parseInt(prefix));
        }

        for (int i = 0; i < remaining.length(); i++) {
            generateCombinations(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), combinations);
        }
    }
}
