package 알고리즘분류.브루트포스알고리즘.복습문제;

import java.io.*;

public class 한수 {

    private static final int MIN_HANSU_LIMIT = 100;
    private static final int DEFAULT_HANSU_COUNT = 99;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int hansuNumber = getHansuCount(N);
        bufferedWriter.write(String.valueOf(hansuNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getHansuCount(int upperLimit) {
        if (upperLimit < MIN_HANSU_LIMIT) return upperLimit;

        int hansuCount = DEFAULT_HANSU_COUNT;
        for (int i = MIN_HANSU_LIMIT; i <= upperLimit; i++) {
            if (isHansuNumber(i)) hansuCount++;
        }

        return hansuCount;
    }

    private static boolean isHansuNumber(int number) {
        int hundred = number / 100;
        int ten = (number / 10) % 10;
        int one = number % 10;

        // 한수는 백의 자리와 십의 자리 차이가 십의 자리와 일의 자리의 차이와 같아야 하므로 다음과 같이 비교하여 판단한다.
        return (hundred - ten) == (ten - one);
    }
}
