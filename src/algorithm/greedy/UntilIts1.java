package algorithm.greedy;

import java.util.Scanner;

public class UntilIts1 {

    /** 예제 - 1이 될 때까지
     *  어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다
     *  ( 단, 두 번째 연산은 N이 K로 나누어 떨어질 때만 선택할 수 있다 )
     *  1. N에서 1을 뺀다
     *  2. N을 K로 나눈다
     *  N과 K가 주어질 때, N이 1이 될 때까지 수행해야 하는 최소 횟수를 구하는 프로그램을 작성하라
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int result = 0;

        while (true) {

            // N이 K로 나누어 떨어지는 수가 될 때까지 빼기
            int target = (N / K) * K;

            result += (N - target);

            N = target;

            // N이 K보다 작을 경우 ( 즉, 더 이상 나눌 수 없을 때 ), 반복문을 탈출
            if (N < K) break;

            result += 1;

            N /= K;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += N - 1;
        System.out.println(result);
    }
}
