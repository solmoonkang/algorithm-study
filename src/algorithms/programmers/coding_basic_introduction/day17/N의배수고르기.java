package algorithms.programmers.coding_basic_introduction.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N의배수고르기 {

    /**
     * [ 문제 설명 ]
     * 정수 n과 정수 배열 numlist가 매개변수로 주어질 때, numlist에서 n의 배수가 아닌 수들을 제거한 배열을 반환하라.
     */
    public int[] solution(int n, int[] numlist) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] % n == 0) {
                list.add(numlist[i]);
            }
        }
        return list.stream().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
        N의배수고르기 selectMultiplesOfN = new N의배수고르기();
        int[] firstNumList = {4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] secondNumList = {1, 9, 3, 10, 13, 5};
        int[] thirdNumList = {2, 100, 120, 600, 12, 12};
        System.out.println("Result: " + Arrays.toString(selectMultiplesOfN.solution(3, firstNumList)));
        System.out.println("Result: " + Arrays.toString(selectMultiplesOfN.solution(5, secondNumList)));
        System.out.println("Result: " + Arrays.toString(selectMultiplesOfN.solution(12, thirdNumList)));
    }
}
