package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 감소하는수 {

    private static final long NO_DECREASING_NUMBER = -1;
    private static final List<Long> decreasingNumbers = new ArrayList<>();

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        long decreasingNumber = findDecreasingNumber();
        bufferedWriter.write(String.valueOf(decreasingNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static long findDecreasingNumber() {
        generateDecreasingNumbers(0, 10);

        Collections.sort(decreasingNumbers);

        if (N < decreasingNumbers.size()) return decreasingNumbers.get(N);
        else return NO_DECREASING_NUMBER;
    }

    private static void generateDecreasingNumbers(long current, int lastDigit) {
        if (current > 0) decreasingNumbers.add(current);
        // 가능한 마지막 숫자인 lastDigit에서 시작하여 0까지의 숫자를 하나씩 사용하여 내림차순의 숫자를 생성한다.
        for (int digit = lastDigit - 1; digit >= 0; digit--) generateDecreasingNumbers(current * 10 + digit, digit);
    }
}
