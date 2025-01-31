package 알고리즘분류.구현;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세수정렬 {

    private static final int NUMBER_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[NUMBER_COUNT];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < NUMBER_COUNT; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        Arrays.sort(numbers);
        for (int number : numbers) bufferedWriter.write(number + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
