package programmers.kit.stack_que;

import java.util.*;

public class 같은숫자는싫어 {

    public int[] solution_queue(int[] arr) {

        Queue<Integer> queue = new LinkedList<>();

        // 이전에 확인한 숫자를 저장하는 변수로, 초기값은 -1
        int value = -1;

        // 주어진 배열의 모든 요소를 검사
        for (int i = 0; i < arr.length; i++) {

            // 현재 숫자 ( arr[i] ) 가 이전 숫자 ( value ) 와 같지 않을 때만 코드를 실행
            if (arr[i] != value) {

                // 현재 숫자를 Queue 에 추가
                queue.offer(arr[i]);

                // 이전 숫자 ( value ) 를 현재 숫자로 업데이트
                value = arr[i];
            }
        }

        // 결과로 반환할 정수 배열을 만들고, 크기는 Queue 의 크기로 설정
        int[] answer = new int[queue.size()];

        // Queue 의 모든 요소를 반복
        for (int i = 0; i < answer.length; i++) {

            // 모든 요소를 순서대로 꺼내서 answer 배열에 저장
            answer[i] = queue.poll();
        }

        return answer;
    }

    public int[] solution_stack(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (stack.size() == 0 || arr[i] != stack.peek()) {

                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {

            answer[i] = stack.pop();
        }

        return answer;
    }

    public int[] solution_list(int[] arr) {

        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        // 이전에 확인한 숫자를 저장하는 변수로, 초기값은 -1
        int value = -1;

        // 주어진 배열의 모든 요소를 검사
        for (int i = 0; i < arr.length; i++) {

            // 현재 숫자 ( arr[i] ) 가 이전 숫자 ( value ) 와 같지 않을 때만 코드를 실행
            if (arr[i] != value) {

                // 현재 숫자를 list 에 추가
                list.add(arr[i]);

                // 이전 숫자 ( value ) 를 현재 숫자로 업데이트
                value = arr[i];
            }
        }

        // ArrayList 를 배열로 변환
        answer = list.stream().mapToInt(x -> x).toArray();

        return answer;
    }

    public static void main(String[] args) {

        같은숫자는싫어 hateSameNumber = new 같은숫자는싫어();

        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        System.out.println("Answer : " + Arrays.toString(hateSameNumber.solution_list(arr)));
        System.out.println("Answer : " + Arrays.toString(hateSameNumber.solution_stack(arr)));
        System.out.println("Answer : " + Arrays.toString(hateSameNumber.solution_queue(arr)));
    }
}
