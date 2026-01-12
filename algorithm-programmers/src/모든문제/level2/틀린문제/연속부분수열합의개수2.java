package 모든문제.level2.틀린문제;

import java.io.*;
import java.util.*;

public class 연속부분수열합의개수2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] elements = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            elements[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int subarraySumCount = countUniqueCircularSubarraySums(elements);
        bufferedWriter.write(String.valueOf(subarraySumCount));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int countUniqueCircularSubarraySums(int[] elements) {
        // 원형 수열의 연속 부분 수열의 합을 저장할 Set 자료구조 선언
        Set<Integer> subarraySumCounts = new HashSet<>();
        int N = elements.length;

        int[] doubleElements = new int[N * 2];
        for (int i = 0; i < N; i++) {
            doubleElements[i] = elements[i];        // 원본 복사
            doubleElements[i + N] = elements[i];    // 뒤에 한 번 더 복사하여 원형 효과 생성
        }

        // 길이가 L인 합을 모두 찾기 위해 elements 배열을 순회
        for (int L = 1; L <= N; L++) {
            for (int S = 0; S < N; S++) {
                int currentSum = 0;

                for (int i = 0; i < L; i++) {
                    int index = (S + i);
                    currentSum += doubleElements[index];
                }

                subarraySumCounts.add(currentSum);
            }
        }

        return subarraySumCounts.size();
    }
}
