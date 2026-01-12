package 모든문제.level1;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class 없는숫자더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        int sum = getSumNotExistNumberInArray(numbers);
        bufferedWriter.write(String.valueOf(sum));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getSumNotExistNumberInArray(int[] numbers) {
        int fullDigitSum = 45;

        int presentDigitSum = 0;
        for (int number : numbers) presentDigitSum += number;

        return fullDigitSum - presentDigitSum;
    }

    private static int anotherSolution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }
}
