package 모든문제.level1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 제일작은수제거하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        int[] sequences = getSequencesRemoveMinNumber(numbers);
        for (int number : sequences) bufferedWriter.write(number + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getSequencesRemoveMinNumber(int[] numbers) {
        if (numbers.length == 1) return new int[]{-1};

        int minNumber = Integer.MAX_VALUE;
        for (int number : numbers) minNumber = Math.min(minNumber, number);

        int[] sequences = new int[numbers.length - 1];
        int index = 0;

        for (int number : numbers) {
            if (number == minNumber) continue;
            sequences[index++] = number;
        }

        return sequences;
    }

    private static int[] anotherSolution(int[] numbers) {
        if (numbers.length == 1) return new int[]{-1};
        int minNumber = Arrays.stream(numbers).min().getAsInt();

        return Arrays.stream(numbers)
                .filter(number -> number != minNumber)
                .toArray();
    }
}
