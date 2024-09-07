package programmers.모든문제.level1.알고리즘고득점KIT;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 같은숫자는싫어 {

    // TODO: 스택과 큐에 대한 동작원리 이해가 부족한 것 같음.
    public int[] solution(int[] arr) {
        Deque<Integer> distinct = new ArrayDeque<>();
        if (arr.length > 0) distinct.offerLast(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != distinct.peekLast()) distinct.offerLast(arr[i]);
        }

        return distinct.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        같은숫자는싫어 problem = new 같은숫자는싫어();

        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        System.out.println("problem = " + Arrays.toString(problem.solution(arr1)));

        int[] arr2 = {4, 4, 4, 3, 3};
        System.out.println("problem = " + Arrays.toString(problem.solution(arr2)));
    }
}
