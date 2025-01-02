package baekjoon.알고리즘분류.해시를사용한집합과맵.복습문제;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 두배열의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] A = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(stringTokenizer.nextToken());

        int M = Integer.parseInt(bufferedReader.readLine());
        int[] B = new int[M];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) B[i] = Integer.parseInt(stringTokenizer.nextToken());

        int totalCount = countPairsWithTotal(A, B, T);
        bufferedWriter.write(String.valueOf(totalCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int countPairsWithTotal(int[] A, int[] B, int T) {
        Map<Integer, Integer> targetCountMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int total = 0;

            for (int j = i; j < A.length; j++) {
                total += A[j];
                targetCountMap.put(total, targetCountMap.getOrDefault(total, 0) + 1);
            }
        }

        int count = 0;

        for (int i = 0; i < B.length; i++) {
            int total = 0;

            for (int j = i; j < B.length; j++) {
                total += B[j];
                count += targetCountMap.getOrDefault(T - total, 0);
            }
        }

        return count;
    }
}
