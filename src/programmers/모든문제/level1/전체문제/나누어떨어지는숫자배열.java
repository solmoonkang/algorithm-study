package programmers.모든문제.level1.전체문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 나누어떨어지는숫자배열 {

    /**
     * [ 문제 설명 ]
     * array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
     * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
     */

    /**
     * [ 제한 사항 ]
     * arr은 자연수를 담은 배열입니다.
     * 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
     * divisor는 자연수입니다.
     * array는 길이 1 이상인 배열입니다.
     */
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }

        if (list.isEmpty()) {
            list.add(-1);
        }

        return list.stream().sorted().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
        나누어떨어지는숫자배열 arrayDivisor = new 나누어떨어지는숫자배열();
        int[] firstArr = {5, 9, 7, 10};
        int[] secondArr = {2, 36, 1, 3};
        int[] thirdArr = {3, 2, 6};
        System.out.println("Result: " + Arrays.toString(arrayDivisor.solution(firstArr, 5)));
        System.out.println("Result: " + Arrays.toString(arrayDivisor.solution(secondArr, 1)));
        System.out.println("Result: " + Arrays.toString(arrayDivisor.solution(thirdArr, 10)));
    }
}
