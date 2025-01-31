package 알고리즘분류.해시를사용한집합과맵;

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

        Map<Integer, Integer> subarrayMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                subarrayMap.put(sum, subarrayMap.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = i; j < M; j++) {
                sum += B[j];
                count += subarrayMap.getOrDefault(T - sum, 0);
            }
        }

        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
