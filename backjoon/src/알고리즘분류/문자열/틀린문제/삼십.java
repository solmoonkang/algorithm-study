package 알고리즘분류.문자열.틀린문제;

import java.io.*;
import java.util.*;

public class 삼십 {

    private static final int MULTIPLES_OF_THIRTY = 30;
    private static final int NUMBER_DOES_NOT_EXIST = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = bufferedReader.readLine();

        Set<Integer> combinations = new HashSet<>();
        generateCombination("", N, combinations);

        List<Integer> sequences = new ArrayList<>();
        for (int combination : combinations) {
            if (combination > 0 && combination % MULTIPLES_OF_THIRTY == 0) sequences.add(combination);
        }

        sequences.sort(Comparator.reverseOrder());
        long maxNumber = sequences.isEmpty() ? NUMBER_DOES_NOT_EXIST : sequences.get(0);
        bufferedWriter.write(String.valueOf(maxNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generateCombination(String prefix, String remaining, Set<Integer> combinations) {
        if (remaining.isEmpty()) {
            combinations.add(Integer.parseInt(prefix));
        }

        for (int i = 0; i < remaining.length(); i++) {
            generateCombination(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), combinations);
        }
    }
}
