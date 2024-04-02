package studying_algorithm.stackqueue.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class IDoNotLikeTheSameNumber {

    public int[] solution_deque(int[] arr) {

        Deque<Integer> deque = new LinkedList<>();

        // 이전에 확인한 숫자를 저장하는 변수, 초기값으로 -1 을 지정
        int value = -1;

        for (int i = 0; i < arr.length; i++) {

            // 현재 숫자 arr[i] 가 이전 숫자 value 와 같지 않을 경우, 실행
            if (arr[i] != value) {

                // 현재 숫자를 Deque 에 저장
                deque.offerLast(arr[i]);

                // 이전 숫자 value 를 현재 숫자로 업데이트
                value = arr[i];
            }
        }

        // 결과로 반환할 정수 배열을 만들고, 크기는 Deque 의 크기로 설정
        int[] answer = new int[deque.size()];

        for (int i = 0; i < answer.length; i++) {

            // 모든 요소를 순서대로 꺼내서 answer 배열에 저장
            answer[i] = deque.pollFirst();
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        IDoNotLikeTheSameNumber iDoNotLikeTheSameNumber = new IDoNotLikeTheSameNumber();

        System.out.println("Result" + Arrays.toString(iDoNotLikeTheSameNumber.solution_deque(arr)));
    }
}
