package 알고리즘분류.정렬;

import java.io.*;
import java.util.Arrays;

public class 수정렬하기_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(numbers);

        for (int index : numbers) {
            bufferedWriter.write(String.valueOf(index));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
