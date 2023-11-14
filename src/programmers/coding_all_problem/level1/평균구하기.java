package programmers.coding_all_problem.level1;

import java.util.Arrays;

/**
 * 문제 설명 : 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
 * 제한 조건 : - arr은 길이 1 이상, 100 이하인 배열입니다.
 *          - arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
 * 입/출력 : - [1,2,3,4]	2.5
 *         - [5,5]	5
 */

public class 평균구하기 {

    public double average(int[] arr) {
//        double answer = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            answer += arr[i];
//        }
//        double ave = answer / arr.length;
//
//        return ave;

        return (int) Arrays.stream(arr).average().orElse(0);
    }

    public static void main(String[] args) {
        평균구하기 solution = new 평균구하기();
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 5};
        System.out.println("answer : " + solution.average(arr1));
        System.out.println("answer : " + solution.average(arr2));
    }
}
