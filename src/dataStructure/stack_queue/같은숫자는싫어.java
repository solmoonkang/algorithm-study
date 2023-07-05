package dataStructure.stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 같은숫자는싫어 {

    /**
     * 문제 설명
     * 배열 arr 의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
     * 이때, 배열 arr 에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
     * 단, 제거된 후 남은 수들을 반환할 때는 배열 arr 의 원소들의 순서를 유지해야 합니다.
     * 배열 arr 에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
     *
     * 예시
     * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
     * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
     */

    public int[] solution_queue(int []arr) {

        Queue<Integer> queue = new LinkedList<>();

        int[] answer = {};

        return answer;
    }

    public int[] solution_stack(int []arr) {

        // arr 배열의 값을 stack 을 통해서 연속적으로 나타나는 숫자를 제거하고,
        // 제거된 값들을 역순으로 정렬한다
        // 이후, 해당 값들을 answer 배열로 담아서 반환한다

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (!stack.isEmpty()) {     // stack 이 비어있지 않으면,
                if (stack.peek() != arr[i]) {       // 이전 숫자와 다르면,
                    stack.push(arr[i]);             // stack 에 push
                }
            } else {        // stack 에 아무것도 없다면,

                stack.push(arr[i]);     // 그냥 바로 stack 에 push
            }
        }

        int[] answer = new int[stack.size()];

        // stack 은 pop 하게 되면, FILO 이므로 역순서로 배열에 넣는다
        for (int i = stack.size() - 1; i >= 0; i--) {

            answer[i] = stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {

        같은숫자는싫어 hateSameNumber = new 같은숫자는싫어();

        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        System.out.println("Answer : " + Arrays.toString(hateSameNumber.solution_queue(arr)));
        System.out.println("Answer : " + Arrays.toString(hateSameNumber.solution_stack(arr)));
    }
}
