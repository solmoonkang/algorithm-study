package baekjoon.알고리즘분류.브루트포스알고리즘.연습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 부분집합의합 {

    /**
     * 문제 설명:
     * 정수 배열 numbers와 목표 정수 target이 주어질 때, 부분 집합의 합이 target이 되는 부분 집합이 존재하는지 확인하세요.
     * 부분 집합은 배열에서 원소를 선택하여 이루어집니다.
     * <p>
     * 입력:
     * 첫 번째 줄에 배열의 크기 N (1 ≤ N ≤ 20).
     * 두 번째 줄에 N개의 정수로 이루어진 배열 numbers.
     * 세 번째 줄에 목표 정수 target.
     * <p>
     * 출력:
     * 존재하면 YES, 존재하지 않으면 NO.
     */

    private static boolean isFoundRecursive = false;
    private static boolean isFoundBitmask = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int target = Integer.parseInt(bufferedReader.readLine());

        generateSubsetsRecursive(numbers, target, 0, 0);
        bufferedWriter.write(isFoundRecursive ? "Recursive = YES\n" : "Recursive = NO\n");

        generateSubsetsBitmask(N, numbers, target);
        bufferedWriter.write(isFoundBitmask ? "Bitmask = YES" : "Bitmask = NO");

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static void generateSubsetsRecursive(int[] numbers, int target, int index, int currentSum) {
        if (currentSum == target) {
            isFoundRecursive = true;
            return;
        }

        if (index >= numbers.length) return;

        generateSubsetsRecursive(numbers, target, index + 1, currentSum + numbers[index]);
        generateSubsetsRecursive(numbers, target, index + 1, currentSum);
    }

    public static void generateSubsetsBitmask(int N, int[] numbers, int target) {
        for (int mask = 0; mask < (1 << N); mask++) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) sum += numbers[i];
            }

            if (sum == target) {
                isFoundBitmask = true;
                break;
            }
        }
    }
}
