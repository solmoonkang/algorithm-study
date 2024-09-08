package programmers.모든문제.level1.복습문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 나누어떨어지는숫자배열 {

    public int[] solution(int[] arr, int divisor) {
        List<Integer> numberArray = new ArrayList<>();
        for (int number : arr) {
            if (number % divisor == 0) numberArray.add(number);
        }

        if (numberArray.isEmpty()) return new int[]{-1};

        int[] answer = numberArray.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        나누어떨어지는숫자배열 problem = new 나누어떨어지는숫자배열();

        int[] arr1 = {5, 9, 7, 10};
        System.out.println("problem = " + Arrays.toString(problem.solution(arr1, 5)));

        int[] arr2 = {2, 36, 1, 3};
        System.out.println("problem = " + Arrays.toString(problem.solution(arr2, 1)));

        int[] arr3 = {3, 2, 6};
        System.out.println("problem = " + Arrays.toString(problem.solution(arr3, 10)));
    }
}
