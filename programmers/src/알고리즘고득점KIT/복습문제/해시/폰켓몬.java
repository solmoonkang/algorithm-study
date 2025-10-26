package 알고리즘고득점KIT.복습문제.해시;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 폰켓몬 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        bufferedReader.close();

        int phoneketmonNumber = findMaxPhoneketmonNumber(numbers);
        bufferedWriter.write(String.valueOf(phoneketmonNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int findMaxPhoneketmonNumber(int[] numbers) {
        int phoneketmonLimit = numbers.length / 2;
        int uniqueNumber = (int) Arrays.stream(numbers).distinct().count();
        return Math.min(uniqueNumber, phoneketmonLimit);
    }
}
