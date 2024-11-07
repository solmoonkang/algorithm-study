package baekjoon.단계문제.그리디알고리즘;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] waitingTimes = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            waitingTimes[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        // 1. 선택 절차: 대기 시간을 오름차순으로 정렬한다.
        Arrays.sort(waitingTimes);

        int totalWaitingTime = 0;
        int cumulativeTime = 0;

        // 2. 적절성 검사: 각 사람의 인출 대기 시간을 합산한다.
        for (int time : waitingTimes) {
            cumulativeTime += time;
            totalWaitingTime += cumulativeTime;
        }

        // 3. 해답 검사: 총 대기 시간을 출력한다.
        bufferedWriter.write(String.valueOf(totalWaitingTime));

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
