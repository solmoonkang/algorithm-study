package programmers.입문문제.day10;

import java.util.Arrays;

public class 배열회전시키기 {

    /**
     * [ 문제 설명 ]
     * 정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다.
     * 배열 numbers의 원소를 direction방향으로 한 칸씩 회전시킨 배열을 반환하라.
     */
    public int[] solution(int[] numbers, String direction) {
        int[] answer = numbers.clone();
        int right = numbers[numbers.length - 1];
        int left = numbers[0];

        if (direction.matches("right")) {
            for (int i = numbers.length - 1; i >= 1; i--) {
                answer[i] = answer[i - 1];
            }
            answer[0] = right;
        }

        if (direction.matches("left")) {
            for (int i = 0; i < numbers.length - 1; i++) {
                answer[i] = answer[i + 1];
            }
            answer[numbers.length - 1] = left;
        }

        return answer;
    }

    public static void main(String[] args) {
        배열회전시키기 rotateArray = new 배열회전시키기();
        int[] firstNumbers = {1, 2, 3};
        int[] secondNumbers = {4, 455, 6, 4, -1, 45, 6};
        System.out.println("Result: " + Arrays.toString(rotateArray.solution(firstNumbers, "right")));
        System.out.println("Result: " + Arrays.toString(rotateArray.solution(secondNumbers, "left")));
    }
}
