package algorithm.queue;

import java.util.Deque;
import java.util.LinkedList;

public class Process {

    // Queue 자료구조를 사용해여 해결이 가능하다
    // 프로세스가 실행 대기열에서 순차적으로 꺼내져서 처리되고, 특정 조건에 따라 다시 대기열 끝에 추가되는 동작이 Queue 의 특성과 일치한다


    // 실행 대기 큐에서 대기중인 프로세스 하나를 꺼낸다
    // 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면, 방금 꺼낸 프로세스를 다시 큐에 넣는다
    // 만약, 그런 프로세스가 없다면, 방금 꺼낸 프로세스를 실행한다 ( 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료한다 )

    public int solution(int[] priorities, int location) {

        // 덱을 생성하고, 이 덱은 각 프로세스의 위치 정보를 저장하는 역할
        Deque<Integer> deque = new LinkedList<>();

        // 모든 프로세스를 순서대로 덱에 넣으며, 여기서 i는 각 프로세스의 초기 위치( 인덱스 )를 의미
        for (int i = 0; i < priorities.length; i++) {
            deque.offerLast(i);
        }

        // 실행 순서를 저장할 변수, 즉 지금까지 실행된 프로세스의 개수를 카운트하는 변수
        int answer = 0;

        // 덱이 비어있지 않은 동안, 즉 대기중인 프로세스가 있는 동안 아래 작업을 반복
        while (!deque.isEmpty()) {

            // 대기열에서 가장 앞에 있는( 즉, 가장 먼저 실행해야 하는 ) 프로세스를 꺼냄
            int current = deque.pollFirst();
            // 현재 꺼낸 프로세스보다 우선순위가 높은 다른 프로세스가 있는지 여부를 저장하는 변수
            boolean isHigherPriorityExists = false;

            // 덱의 첫 번째 프로세스의 우선순위보다 더 높은 우선순위의 프로세스가 있는지 확인
            for (int index : deque) {

                // 만약, 우선순위가 높은 다른 프로세스가 있다면,
                if (priorities[index] > priorities[current]) {
                    // 해당 시점에서 for 문을 종료( break )
                    isHigherPriorityExists = true;
                    break;
                }
            }

            // 만약, 더 높은 우선순위의 프로세스가 있다면,
            if (isHigherPriorityExists) {
                // 현재 프로세스를 덱의 뒤쪽에 추가
                deque.offerLast(current);
            // 만약, 없다면
            } else {
                // 프로세스가 실행될 때마다 변수값을 1씩 증가
                answer++;
                // 현재 실행된 프로세스가 우리가 찾고자 하는 프로세스인지를 확인
                if (current == location) {
                    // 만약, 맞다면 현 시점 answer 값이 찾고자 하는 답으로 while 문을 종료
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Process process = new Process();

        int[] priorities = {2, 1, 3, 2};
        int[] priorities2 = {1, 1, 9, 1, 1, 1};

        System.out.println("Result : " + process.solution(priorities, 2));
        System.out.println("Result : " + process.solution(priorities2, 0));
    }
}
