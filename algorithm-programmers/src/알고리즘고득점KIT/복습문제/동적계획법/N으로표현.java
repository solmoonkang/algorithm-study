package 알고리즘고득점KIT.복습문제.동적계획법;

import java.io.*;
import java.util.*;

public class N으로표현 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int number = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();

        int minNumber = findMinNumberExpressedOperations(N, number);
        bufferedWriter.write(String.valueOf(minNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int findMinNumberExpressedOperations(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();

        dp.add(new HashSet<>());

        for (int i = 1; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        dp.get(1).add(N);

        int concat = N;
        for (int i = 2; i <= 8; i++) {
            concat = concat * 10 + N;
            dp.get(i).add(concat);
        }

        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);

                for (int a : set1) {
                    for (int b : set2) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }

            if (dp.get(i).contains(number)) return i;
        }

        return -1;
    }
}
