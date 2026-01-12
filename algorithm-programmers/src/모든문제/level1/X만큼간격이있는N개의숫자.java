package 모든문제.level1;

import java.io.*;
import java.util.StringTokenizer;

public class X만큼간격이있는N개의숫자 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int X = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        long[] sequence = getNumberSequence(X, N);
        for (long number : sequence) bufferedWriter.write(number + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static long[] getNumberSequence(int X, int N) {
        long[] sequence = new long[N];
        for (int i = 0; i < N; i ++) sequence[i] = (long) X * (i + 1);
        return sequence;
    }
}
