package 모든문제.level3.전체문제;

import java.util.PriorityQueue;

public class 야근지수 {

    /**
     * [ 문제 설명 ]
     * 회사원 Demi는 가끔은 야근을 하는데요, 야근을 하면 야근 피로도가 쌓입니다.
     * 야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다.
     * Demi는 N시간 동안 야근 피로도를 최소화하도록 일할 겁니다.
     * Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때,
     * 퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해 야근 피로도를 최소화한 값을 리턴하는 함수 solution을 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * works는 길이 1 이상, 20,000 이하인 배열입니다.
     * works의 원소는 50000 이하인 자연수입니다.
     * n은 1,000,000 이하인 자연수입니다.
     */
    public long solution(int n, int[] works) {
        // TODO: 우선순위 큐를 사용하면 손쉽게 풀 수 있음. 전체적으로 많이 근접했다고 생각함. 다시 한 번 풀어보자.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int work : works) {
            maxHeap.add(work);
        }

        while (n-- > 0 && !maxHeap.isEmpty()) {
            int maxWork = maxHeap.poll();
            if (maxWork > 0) maxHeap.add(maxWork - 1);
        }

        return maxHeap.stream().mapToLong(i -> (long) i * i).sum();
    }

    public static void main(String[] args) {
        야근지수 overtimeIndex = new 야근지수();

        int[] firstWorks = {4, 3, 3};
        System.out.println("overtimeIndex = " + overtimeIndex.solution(4, firstWorks));

        int[] secondWorks = {2, 1, 2};
        System.out.println("overtimeIndex = " + overtimeIndex.solution(1, secondWorks));

        int[] thirdWorks = {1, 1};
        System.out.println("overtimeIndex = " + overtimeIndex.solution(3, thirdWorks));
    }
}
