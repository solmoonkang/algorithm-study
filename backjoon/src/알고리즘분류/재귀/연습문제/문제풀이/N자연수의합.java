package 알고리즘분류.재귀.연습문제.문제풀이;

import java.io.*;
import java.util.StringTokenizer;

public class N자연수의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] sequences = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) sequences[i] = Integer.parseInt(stringTokenizer.nextToken());

        int numberSum = generateSequencesNumberSum(N, sequences);
        bufferedWriter.write(String.valueOf(numberSum));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int generateSequencesNumberSum(int N, int[] sequences) {
        if (N == 0) return 0;
        return sequences[N - 1] + generateSequencesNumberSum(N - 1, sequences);
    }
}
