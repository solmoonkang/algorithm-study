package baekjoon.알고리즘분류.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class 부분수열의합 {

    private static int N, S;
    private static int[] numbers;
    private static int subsequencesCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        findSubsequences(0, 0, 0);      // 인덱스, 현재 합, 선택된 요소 개수를 전달

        bufferedWriter.write(String.valueOf(subsequencesCount));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void findSubsequences(int index, int currentSum, int count) {
        // 기저 조건: 모든 숫자를 사용한 경우
        if (index == N) {
            // 현재 합이 S와 같고, 선택된 요소가 하나 이상일 때만 카운트 증가
            if (currentSum == S && count > 0) subsequencesCount++;
            return;
        }

        // 현재 숫자를 포함하는 경우
        findSubsequences(index + 1, currentSum + numbers[index], count + 1);

        // 현재 숫자를 포함하지 않는 경우
        findSubsequences(index + 1, currentSum, count);
    }
}
