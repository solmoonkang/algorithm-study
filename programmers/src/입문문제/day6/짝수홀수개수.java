package 입문문제.day6;

import java.util.Arrays;

public class 짝수홀수개수 {

    /**
     * 정수가 담긴 리스트 num_list가 주어질 때,
     * num_list의 원소 중 짝수와 홀수의 개수를 담은 배열을 반환하라.
     */
    public int[] solution(int[] num_list) {
        int even = 0;
        int odd = num_list.length;

        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) {
                even++;
                odd--;
            }
        }
        return new int[]{even, odd};
    }

    public static void main(String[] args) {
        짝수홀수개수 numberOfEvenOdd = new 짝수홀수개수();
        int[] firstNumList = {1, 2, 3, 4, 5};
        int[] secondNumList = {1, 3, 5, 7};
        System.out.println("Result: " + Arrays.toString(numberOfEvenOdd.solution(firstNumList)));
        System.out.println("Result: " + Arrays.toString(numberOfEvenOdd.solution(secondNumList)));
    }
}
