package algorithm.queue;

import java.util.Deque;
import java.util.LinkedList;

public class Process {

    public int solution(int[] priorities, int location) {

        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            deque.offerLast(i);
        }

        // 실행 순서를 저장할 변수
        int answer = 0;

        while (!deque.isEmpty()) {
            // 덱의 첫 번째 프로세스를 current 변수에 저장
            int current = deque.pollFirst();
            // 더 높은 우선순위가 있는지 여부를 판단하는 변수
            boolean isHigherPriorityExists = false;

            // 덱의 첫 번째 프로세스의 우선순위보다 더 높은 우선순위의 프로세스가 있는지 확인
            for (int index : deque) {
                // 해당 우선순위 판단 여부 변수를 true 로 변경
                if (priorities[index] > priorities[current]) {
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
                // 프로세스를 실행하고 실행 순서를 증가
                answer++;
                // 현재 프로세스가 찾고자 하는 프로세스와 일치한다면 반복을 종료
                if (current == location) {
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
