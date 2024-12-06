package baekjoon.알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class 보물 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        String[] inputA = bufferedReader.readLine().split(" ");
        String[] inputB = bufferedReader.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(inputA[i]);
            B[i] = Integer.parseInt(inputB[i]);
        }

        Arrays.sort(A);
        Arrays.sort(B, Comparator.reverseOrder());

        int minTotal = 0;

        for (int i = 0; i < N; i++) {
            minTotal += A[i] * B[i];
        }

        bufferedWriter.write(String.valueOf(minTotal));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
