package algorithms.algorithm.datastructures.stackqueue.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IDoNotLikeTheSameNumber {

    public int[] solution_stack(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            // 스택이 비어있거나 스택의 최상단 원소가 현재 원소와 다를 경우,
            if (stack.isEmpty() || stack.peek() != arr[i]) {
                // 스택에 삽입
                stack.push(arr[i]);
            }
        }

        List<Integer> list = new ArrayList<>();

        // 스택에 저장된 원소를 리스트에 저장
        while (!stack.isEmpty()) {
            // index 를 0으로 지정한 이유는 스택에 있는 값들을 리스트에 순서대로 넣기 위함으로
            // 스택에서 꺼낸 원소가 리스트의 맨 앞에 추가되어 결과적으로 원소들이 리스트에 순서대로 저장
            list.add(0, stack.pop());
        }

        return list.stream().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {

        IDoNotLikeTheSameNumber number = new IDoNotLikeTheSameNumber();

        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};

        System.out.println("Result : " + Arrays.toString(number.solution_stack(arr)));
        System.out.println("Result : " + Arrays.toString(number.solution_stack(arr2)));
    }
}
