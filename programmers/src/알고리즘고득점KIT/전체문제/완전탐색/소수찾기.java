package 알고리즘고득점KIT.전체문제.완전탐색;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String numbers = bufferedReader.readLine();

        int primeNumber = getAttachPaperToPrimeNumberCount(numbers);
        bufferedWriter.write(String.valueOf(primeNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getAttachPaperToPrimeNumberCount(String numbers) {
        Set<Integer> primeNumberSet = new HashSet<>();
        generateCombinationsWithRecursion("", numbers, primeNumberSet);
        return primeNumberSet.size();
    }

    private static void generateCombinationsWithRecursion(String prefix, String remaining, Set<Integer> combinations) {
        if (!prefix.isEmpty()) {
            int number = Integer.parseInt(prefix);
            if (isPrimeNumber(number)) combinations.add(number);
        }

        for (int i = 0; i < remaining.length(); i++) {
            generateCombinationsWithRecursion(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), combinations);
        }
    }

    private static void generateCombinationsWithBitmask(String numbers, Set<Integer> combinations) {
        int N = numbers.length();

        for (int mask = 1; mask < (1 << N); mask++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) stringBuilder.append(numbers.charAt(i));
            }

            if (!stringBuilder.isEmpty()) {
                int number = Integer.parseInt(stringBuilder.toString());
                if (isPrimeNumber(number)) combinations.add(number);
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) return false;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
