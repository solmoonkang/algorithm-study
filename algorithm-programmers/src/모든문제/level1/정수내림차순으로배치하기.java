package 모든문제.level1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 정수내림차순으로배치하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long number = Long.parseLong(bufferedReader.readLine());

        long sortNumber = getSortDescNumber(number);
        bufferedWriter.write(String.valueOf(sortNumber));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static long getSortDescNumber(long number) {
        List<Character> sequences = new ArrayList<>();

        String num = String.valueOf(number);

        for (int i = 0; i < num.length(); i++) {
            sequences.add(num.charAt(i));
        }

        sequences.sort(Comparator.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();
        for (char current : sequences) stringBuilder.append(current);

        return Long.parseLong(stringBuilder.toString());
    }

    private static long anotherSolution(long number) {
        char[] digits = String.valueOf(number).toCharArray();
        Arrays.sort(digits);

        StringBuilder stringBuilder = new StringBuilder(new String(digits));
        stringBuilder.reverse();

        return Long.parseLong(stringBuilder.toString());
    }
}
