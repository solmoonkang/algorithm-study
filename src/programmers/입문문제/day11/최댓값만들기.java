package programmers.입문문제.day11;

import java.util.Arrays;

public class 최댓값만들기 {

    /**
     * [ 문제 설명 ]
     * 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 반환하라.
     */
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length - 1] * numbers[numbers.length - 2];
    }

    public static void main(String[] args) {
        최댓값만들기 maximumValueMaker = new 최댓값만들기();
        int[] firstNumbers = {1, 2, 3, 4, 5};
        int[] secondNumbers = {0, 31, 24, 10, 1, 9};
        System.out.println("Result: " + maximumValueMaker.solution(firstNumbers));
        System.out.println("Result: " + maximumValueMaker.solution(secondNumbers));
    }
}
