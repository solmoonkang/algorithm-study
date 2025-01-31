package 알고리즘분류.브루트포스알고리즘.연습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 두수의합 {

    /**
     * 문제 설명:
     * 정수 배열 numbers와 목표 정수 target이 주어질 때, 두 수의 합이 target이 되는 두 수의 인덱스를 찾으세요. 같은 원소를 두 번 사용할 수는 없습니다.
     * 만약 그런 쌍이 없다면 -1을 반환하세요.
     * <p>
     * 입력:
     * 첫 번째 줄에 배열의 크기 N (1 ≤ N ≤ 1000).
     * 두 번째 줄에 N개의 정수로 이루어진 배열 numbers.
     * 세 번째 줄에 목표 정수 target.
     * <p>
     * 출력:
     * 두 수의 인덱스 (0-based) 또는 -1.
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

        int target = Integer.parseInt(bufferedReader.readLine());

        boolean found = false;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    bufferedWriter.write(i + " " + j);
                    found = true;
                    break;
                }
            }

            if (found) break;
        }

        if (!found) bufferedWriter.write("-1");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
