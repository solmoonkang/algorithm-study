package 알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.Arrays;

public class 로프 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] maxWeights = new int[N];

        for (int i = 0; i < N; i++) {
            maxWeights[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(maxWeights);

        int maxLoad = 0;

        // i는 현재 사용하고 있는 로프의 인덱스를 나타낸다. i + 1은 현재 고려하고 있는 로프의 개수를 의미한다.
        for (int i = 0; i < N; i++) {
            int currentLoad = maxWeights[i] * (i + 1);
            maxLoad = Math.max(maxLoad, currentLoad);
        }

        bufferedWriter.write(String.valueOf(maxLoad));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
