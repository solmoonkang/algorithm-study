package algorithms.programmers.coding_basic_introduction.day20;

import java.util.Arrays;

public class 최댓값만들기2 {

    /**
     * [ 문제 풀이 ]
     * 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 반환하라.
     */
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int answer = numbers[numbers.length - 2] * numbers[numbers.length - 1];
        int compare = 1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                compare *= numbers[i];
            }

            if (compare > 0) {
                if (compare > answer) {
                    answer = compare;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        최댓값만들기2 maximizingValue = new 최댓값만들기2();
        int[] firstNumbers = {1, 2, -3, 4, -5};
        int[] secondNumbers = {0, -31, 24, 10, 1, 9};
        int[] thirdNumbers = {10, 20, 30, 5, 5, 20, 5};
        System.out.println("Result: " + maximizingValue.solution(firstNumbers));
        System.out.println("Result: " + maximizingValue.solution(secondNumbers));
        System.out.println("Result: " + maximizingValue.solution(thirdNumbers));
    }
}
