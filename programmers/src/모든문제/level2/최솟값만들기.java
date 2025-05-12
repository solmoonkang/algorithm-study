package 모든문제.level2;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 최솟값만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(stringTokenizer.nextToken());

        int minNumber = generateMinNumber(A, B);
        bufferedWriter.write(String.valueOf(minNumber));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int generateMinNumber(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(Arrays.stream(B).boxed().toArray(Integer[]::new), Collections.reverseOrder());

        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[i];
        }

        return sum;
    }
}
