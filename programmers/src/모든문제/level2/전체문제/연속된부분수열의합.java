package 모든문제.level2.전체문제;

import java.util.Arrays;

public class 연속된부분수열의합 {

    /**
     * [ 문제 설명 ]
     * 비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.
     *
     * 기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
     * 부분 수열의 합은 k입니다.
     * 합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
     * 길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
     * 수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때,
     * 위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요.
     * 이때 수열의 인덱스는 0부터 시작합니다.
     */

    /**
     * [ 제한 사항 ]
     * 5 ≤ sequence의 길이 ≤ 1,000,000
     *  - 1 ≤ sequence의 원소 ≤ 1,000
     *  - sequence는 비내림차순으로 정렬되어 있습니다.
     * 5 ≤ k ≤ 1,000,000,000
     *  - k는 항상 sequence의 부분 수열로 만들 수 있는 값입니다.
     */
    public int[] solution(int[] sequence, int k) {
        // TODO: 포인트 투 포인트에 대해 공부하자. 그리고서 다시 풀어보자.
        int start = 0;
        int end = 0;
        int sum = 0;

        int minLength = Integer.MAX_VALUE;

        int[] answer = new int[2];

        while (end < sequence.length) {
            sum += sequence[end];

            while (sum >= k) {
                if (sum == k) {
                    if (end - start < minLength) {
                        minLength = end - start;
                        answer[0] = start;
                        answer[1] = end;
                    }
                }
                sum -= sequence[start++];
            }
            end++;
        }

        return answer;
    }

    public static void main(String[] args) {
        연속된부분수열의합 sumOfContinuousSubsequences = new 연속된부분수열의합();

        int[] firstSequence = {1, 2, 3, 4, 5};
        System.out.println("sumOfContinuousSubsequences = " +
                Arrays.toString(sumOfContinuousSubsequences.solution(firstSequence, 7)));

        int[] secondSequence = {1, 1, 1, 2, 3, 4, 5};
        System.out.println("sumOfContinuousSubsequences = " +
                Arrays.toString(sumOfContinuousSubsequences.solution(secondSequence, 5)));

        int[] thirdSequence = {2, 2, 2, 2, 2};
        System.out.println("sumOfContinuousSubsequences = " +
                Arrays.toString(sumOfContinuousSubsequences.solution(thirdSequence, 6)));

    }
}
