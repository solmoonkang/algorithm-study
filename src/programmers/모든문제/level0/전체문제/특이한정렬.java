package programmers.모든문제.level0.전체문제;

import java.util.Arrays;

public class 특이한정렬 {

    /**
     * [ 문제 설명 ]
     * 정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다.
     * 이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다.
     * 정수가 담긴 배열 numlist와 정수 n이 주어질 때
     * numlist의 원소를 n으로부터 가까운 순서대로 정렬한 배열을 return하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 1 ≤ n ≤ 10,000
     * 1 ≤ numlist의 원소 ≤ 10,000
     * 1 ≤ numlist의 길이 ≤ 100
     * numlist는 중복된 원소를 갖지 않습니다.
     */
    public int[] solution(int[] numlist, int n) {
        return Arrays.stream(numlist).boxed()
                .sorted((a, b) -> compareDistance(a, b, n))
                .mapToInt(i -> i).toArray();
    }

    private int compareDistance(int a, int b, int n) {
        int distanceA = Math.abs(a - n);
        int distanceB = Math.abs(b - n);

        if (distanceA != distanceB) {
            return Integer.compare(distanceA, distanceB);
        } else {
            return Integer.compare(b, a);
        }
    }

    public static void main(String[] args) {
        특이한정렬 unusualArrangement = new 특이한정렬();

        int[] numlist1 = {1, 2, 3, 4, 5, 6};
        int[] numlist2 = {10000, 20, 36, 47, 40, 6, 10, 7000};

        System.out.println("unusualArrangement = " + Arrays.toString(unusualArrangement.solution(numlist1, 4)));
        System.out.println("unusualArrangement = " + Arrays.toString(unusualArrangement.solution(numlist2, 30)));
    }
}
