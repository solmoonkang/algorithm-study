package algorithms.programmers.coding_basic_introduction.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 약수구하기 {

    /**
     * [ 문제 설명 ]
     * 정수 n이 매개변수로 주어질 때, n의 약수를 오름차순으로 담은 배열을 반환하라.
     */
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
        약수구하기 findingTheDivisors = new 약수구하기();
        System.out.println("Result: " + Arrays.toString(findingTheDivisors.solution(24)));
        System.out.println("Result: " + Arrays.toString(findingTheDivisors.solution(29)));
    }
}
