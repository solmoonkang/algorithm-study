package baekjoon.알고리즘분류.브루트포스알고리즘.연습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 최대공약수 {

    /**
     * 문제 설명:
     * 정수 배열 numbers가 주어질 때, 모든 쌍의 최대 공약수(GCD)를 계산하고, 그 중 최대 값을 구하세요.
     * <p>
     * 입력:
     * 첫 번째 줄에 배열의 크기 N (2 ≤ N ≤ 100).
     * 두 번째 줄에 N개의 정수로 이루어진 배열 numbers.
     * <p>
     * 출력:
     * 최대 공약수의 최대 값.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxGCD = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int currentGCD = getMaxGCD(numbers[i], numbers[j]);
                maxGCD = Math.max(maxGCD, currentGCD);
            }
        }

        bufferedWriter.write(String.valueOf(maxGCD));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getMaxGCD(int A, int B) {
        while (B != 0) {
            int temp = B;
            B = A % B;
            A = temp;
        }

        return A;
    }
}
