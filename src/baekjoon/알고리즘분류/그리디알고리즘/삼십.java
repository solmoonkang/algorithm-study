package baekjoon.알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 삼십 {

    private static final int MULTIPLE_OF_THIRTY = 30;
    private static final String NO_VALID_NUMBER = "-1";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = bufferedReader.readLine();
        List<Integer> permutations = new ArrayList<>();
        generatePermutations("", N, permutations);

        permutations.sort(Comparator.reverseOrder());
        for (int makingNumber : permutations) {
            if (makingNumber % MULTIPLE_OF_THIRTY == 0) bufferedWriter.write(String.valueOf(makingNumber));
            else bufferedWriter.write(NO_VALID_NUMBER);
            break;
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void generatePermutations(String prefix, String remaining, List<Integer> permutations) {
        int N = remaining.length();
        if (N == 0) permutations.add(Integer.parseInt(prefix));

        for (int i = 0; i < N; i++)
            generatePermutations(
                    prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), permutations);
    }
}
