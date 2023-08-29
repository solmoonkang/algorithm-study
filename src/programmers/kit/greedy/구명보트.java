package programmers.kit.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class 구명보트 {

    public int solution(int[] people, int limit) {

        // 1. 선택 절차 : 현 상태에서 최적인 선택을 한다
        // 각 사람의 몸무게를 100kg 에서 뺀 값보다 같거나 작은 값이 있을 경우, 해당 원소들을 제거하고, 구명보트의 개수를 증가시킨다
        // 반면, 100kg 에서 뺀 값보다 같거나 작은 값이 없을 경우, 해당 원소를 제거하고, 구명보트의 개수를 증가시킨다
        // 그러기 위해서 각 사람들의 몸무게를 내림차순으로 정렬한다

        Arrays.sort(people);

        Deque<Integer> deque = new LinkedList<>();

        // 내림차순으로 덱에 추가한다
        for (int i = people.length - 1; i >= 0; i--) {
            deque.offer(people[i]);
        }

        int count = 0;

        // 2. 적절성 검사 : 선택한 항목이 문제의 조건을 만족하는지 확인한다
        while (!deque.isEmpty()) {

            // 현재 가장 무거운 사람을 first 변수에 저장한다
            int first = deque.pollFirst();

            // 만약, 현재 가장 무거운 사람과 가장 가벼운 사람이 함께 탑승이 가능할 경우,
            if (!deque.isEmpty() && first + deque.peekLast() <= limit) {

                // 같이 탑승시킨다
                deque.pollLast();
            }

            count++;
        }

        // 3. 해답 검사 : 최종 선택이 문제의 조건을 만족하는지 확인한다
        return count;
    }

    public static void main(String[] args) {

        구명보트 safeBoat = new 구명보트();

        int[] people = {70, 50, 80, 50};

        System.out.println("Result : " + safeBoat.solution(people, 100));
    }
}
