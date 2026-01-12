package 모든문제.level1;

import java.io.*;
import java.util.StringTokenizer;

public class 평균구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] sequence = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) sequence[i] = Integer.parseInt(stringTokenizer.nextToken());

        double average = calculateAverage(sequence);
        bufferedWriter.write(String.valueOf(average));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static double calculateAverage(int[] sequence) {
        int sum = 0;
        for (int number : sequence) sum += number;

        return (double) sum / sequence.length;
    }
}
