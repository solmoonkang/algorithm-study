package 모든문제.level1;

import java.io.*;
import java.util.StringTokenizer;

public class 두정수사이의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());

        long sum = getSumBetweenAAndB(A, B);
        bufferedWriter.write(String.valueOf(sum));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static long getSumBetweenAAndB(int A, int B) {
        long sum = 0;
        for (int i = Math.min(A, B); i <= Math.max(A, B); i++) sum += i;
        return sum;
    }
}
