package studying_algorithm.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class RamenFactory {

    // stock : 현재 공장에 남아있는 밀가루 수량
    // dates : 밀가루 공급 일정
    // supplies : 해당 시점에 공급 가능한 밀가루 수량
    // k : 원래 공장으로부터 공급받을 수 있는 시점

    public int solution(int stock, int[] dates, int[] supplies, int k) {

        // 최소한 몇 번 해외 공장으로부터 밀가루를 공급받아야 하는지를 return

        int answer = 0;

        // 우선순위 큐를 선언하며, 공급 가능한 밀가루를 내림차순으로 정렬한다
        // 이렇게 할 경우, 매번 가장 많은 양의 공급을 받을 수 있는 현재 가능한 날짜를 빠르게 찾을 수 있다
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        // dates 배열과 supplies 배열의 현재 위치를 추적하는 역할을 한다
        int index = 0;

        // 주어진 기간 k일 동안 반복한다
        for (int i = 0; i < k; i++) {

            // 만약, 날짜 i가 dates 배열에 존재하면,
            if (index < dates.length && dates[index] == i) {

                // 해당 공급 일정과 해당 날짜에 공급받을 수 있는 밀가루 양 ( supplies[index++] )을 우선순위 큐에 추가한다
                priorityQueue.add(supplies[index++]);
            }

            // 만약, 재고가 0이면,
            if (stock == 0) {

                // 최우선으로 공급받을 수 있는 밀가루를 재고에 추가하고,
                stock += priorityQueue.poll();

                // 해외 공장에서 공급받은 횟수를 1을 증가시킨다
                answer++;
            }

            // 재고를 하루 사용하므로, 재고량을 감소시킨다
            stock--;
        }

        // k일 기간이 지난 후, 해외 공장에서 총 공급받은 횟수를 반환한다
        return answer;
    }

    public static void main(String[] args) {

        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};

        RamenFactory ramenFactory = new RamenFactory();

        System.out.println("How many times do you need to get flour from overseas factories : " + ramenFactory.solution(4, dates, supplies, 30));
    }
}
