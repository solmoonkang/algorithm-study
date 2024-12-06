package baekjoon.알고리즘분류.그리디알고리즘;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] processingTime = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            processingTime[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(processingTime);

        // 중첩된 FOR문을 사용하여 불필요하게 많은 연산을 수행하여 O(N^2)의 시간 복잡도를 갖는다.
        /*int minProcessingTime = 0;
        for (int i = 0; i < N; i++) {
           for (int j = 0; j <= i; j++) {
                minProcessingTime += processingTime[j];
           }
        }*/

        // ATM에서 인출하는 데 걸리는 최소 시간을 위해, 각 사람의 처리 시간을 합산할 때 각 사람의 처리 시간을 한 번씩만 고려하면 된다.
        int minProcessingTime = 0;
        int cumulativeTime = 0;

        // 현재 사람의 처리 시간을 누적하고, 누적 처리된 시간을 최소 처리 시간에 추가한다.
        for (int i = 0; i < N; i++) {
            cumulativeTime += processingTime[i];
            minProcessingTime += cumulativeTime;
        }

        bufferedWriter.write(String.valueOf(minProcessingTime));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
