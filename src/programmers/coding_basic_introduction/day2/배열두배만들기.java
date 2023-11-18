package programmers.coding_basic_introduction.day2;

import java.util.Arrays;

public class 배열두배만들기 {

    /**
     * 정수 배열 numbers가 매개변수로 주어집니다. numbers의 각 원소에 두배한 원소를 가진 배열을 반환하라
     */
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i] * 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        배열두배만들기 doubleArray = new 배열두배만들기();
        int[] firstNumbers = {1, 2, 3, 4, 5};
        int[] secondNumbers = {1, 2, 100, -99, 1, 2, 3};
        System.out.println("Result: " + Arrays.toString(doubleArray.solution(firstNumbers)));
        System.out.println("Result: " + Arrays.toString(doubleArray.solution(secondNumbers)));
    }
}
