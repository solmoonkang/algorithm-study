package 입문문제.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 공던지기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int K = Integer.parseInt(bufferedReader.readLine());

        int thrower = findKthThrower(numbers, K);
        bufferedWriter.write(String.valueOf(thrower));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int findKthThrower(int[] numbers, int K) {
        int index = 0;
        int step = 2;
        int thrower = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (index == K) break;
            index = (index + step) % numbers.length;
        }

        return numbers[index];
    }
}
