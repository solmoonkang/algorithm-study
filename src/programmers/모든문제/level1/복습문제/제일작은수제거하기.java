package programmers.모든문제.level1.복습문제;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 제일작은수제거하기 {

    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};

        Deque<Integer> numberDeque = new ArrayDeque<>();

        int min = Integer.MAX_VALUE;
        for (int number : arr) {
            if (number < min) min = number;
        }

        for (int number : arr) {
            if (number != min) numberDeque.offerLast(number);
        }

        return numberDeque.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        제일작은수제거하기 problem = new 제일작은수제거하기();

        int[] arr1 = {4, 3, 2, 1};
        System.out.println("problem = " + Arrays.toString(problem.solution(arr1)));

        int[] arr2 = {10};
        System.out.println("problem = " + Arrays.toString(problem.solution(arr2)));
    }
}
