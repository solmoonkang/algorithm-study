package algorithms.programmers.coding_basic_introduction.day8;

import java.util.Arrays;

public class 배열자르기 {

    /**
     * 정수 배열 numbers와 정수 num1, num2가 매개변수로 주어질 때,
     * numbers의 num1번 째 인덱스부터 num2번째 인덱스까지 자른 정수 배열을 반환하라.
     */
    public int[] solution(int[] numbers, int num1, int num2) {
        // 코드는 올바르게 작동하나, 런타임 에러가 발생한다.
        // List<Integer> list = Arrays.stream(numbers).boxed().toList();
        // return list.subList(num1, num2 + 1).stream().mapToInt(o -> o).toArray();

        // return Arrays.stream(numbers, num1, num2 + 1).toArray();

        // TODO: 배열의 크기와 인덱스에 접근하는 방법에 대해서 공부가 더 필요하다.
        int[] answer = new int[num2 - num1 + 1];
        for (int i = 0; i < num2 - num1 + 1; i++) {
            answer[i] = numbers[num1 + i];
        }
        return answer;
    }

    public static void main(String[] args) {
        배열자르기 arraySlicing = new 배열자르기();
        int[] firstNumbers = {1, 2, 3, 4, 5};
        int[] secondNumbers = {1, 3, 5};
        System.out.println("Result: " + Arrays.toString(arraySlicing.solution(firstNumbers, 1, 3)));
        System.out.println("Result: " + Arrays.toString(arraySlicing.solution(secondNumbers, 1, 2)));
    }
}
