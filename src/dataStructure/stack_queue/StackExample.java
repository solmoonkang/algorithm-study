package dataStructure.stack_queue;

import java.util.Arrays;
import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {

        /**
         * Stack : Last In First Out ( LIFO )
         *
         * stack.push(value) : 값 추가
         * stack.pop( ) : 값 삭제
         * stack.clear( ) : 값 전체 삭제
         * stack.peek( ) : 가장 상단의 값을 출력 ( 가장 마지막에 들어간 값이 출력 )
         *
         * stack.isEmpty( ) : 값이 비었는지 여부를 판단
         * stack.isFull( ) : 값이 가득찼는지 여부를 판단
         * stack.printStack( ) : 모든 값들을 출력
         * stack.size( ) : 크기를 리턴
         *
         * top : 배열의 가장 마지막으로 저장된 요소의 인덱스를 저장
         *       아무런 값도 저장하지 않은 stack 에서 top 은 -1 을 저장
         *       배열의 시작은 언제나 인덱스 = 0 이므로 별도로 bottom 변수를 만들 필요는 없다
         *
         *       추가로, push 연산 시 top 은 기존에 저장하던 index + 1 을 저장하고, 해당 인덱스에 데이터를 저장
         *       마찬가지로, pop 연산 시 top 은 기존에 저장하던 index - 1 을 저장하고, 해당 인덱스에 null 을 저장
         */

        // Stack 선언
        Stack<Integer> stack = new Stack<>();

        // Stack 값 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Stack 값 삭제
        stack.pop();

        // Stack 값 모두 삭제
//        stack.clear();

        // Stack 가장 상단 값 출력
        stack.peek();

        if (stack.contains(1)) {
            System.out.println("Stack : " + stack);
        }


        // ===== Stack 배열 구현 ===== //

        System.out.println("------------------------");

        int[] arr = {1, 2, 3, 4, 5, 6};

        StackExample stackExample = new StackExample();

        System.out.println("Stack : " + Arrays.toString(stackExample.solution_stack(arr)));

    }

    public int[] solution_stack(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (!stack.isEmpty()) {

                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
