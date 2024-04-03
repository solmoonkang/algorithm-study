package programmers.모든문제.level1;

import java.util.*;

public class 명예의전당 {

    /**
     * [ 문제 설명 ]
     * "명예의 전당"이라는 TV 프로그램에서는 매일 1명의 가수가 노래를 부르고, 시청자들의 문자 투표수로 가수에게 점수를 부여합니다.
     * 매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에 올려 기념합니다.
     * 즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당에 오르게 됩니다.
     * k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면,
     * 출연 가수의 점수가 명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.
     *
     * 이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다.
     * 예를 들어, k = 3이고, 7일 동안 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]이라면,
     * 명예의 전당에서 발표된 점수는 아래의 그림과 같이 [10, 10, 10, 20, 20, 100, 100]입니다.
     *
     * 명예의 전당 목록의 점수의 개수 k, 1일부터 마지막 날까지 출연한 가수들의 점수인 score가 주어졌을 때,
     * 매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 3 ≤ k ≤ 100
     * 7 ≤ score의 길이 ≤ 1,000
     *  - 0 ≤ score[i] ≤ 2,000
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 초기화:
     *
     * PriorityQueue (우선순위 큐)를 사용하여 상위 k개의 점수를 관리합니다. 자바에서 PriorityQueue는 기본적으로 최소 힙(min heap)을 구현합니다.
     * 이를 이용하여 항상 최하위 점수를 쉽게 접근할 수 있도록 합니다.
     * 결과를 저장할 리스트를 초기화합니다. 이 리스트는 매일 발표된 명예의 전당의 최하위 점수를 저장합니다.
     *
     * 점수 처리:
     *
     * 입력된 score 배열을 순회하며 각 가수의 점수를 처리합니다.
     * 처음 k일 동안은 모든 점수를 우선순위 큐에 추가합니다. 이 기간 동안은 모든 점수가 명예의 전당에 오르게 됩니다.
     * k일 이후부터는 현재 점수가 우선순위 큐의 최상위(최소) 점수보다 크면, 최상위 점수를 제거하고 현재 점수를 우선순위 큐에 추가합니다.
     * 각 단계에서 우선순위 큐의 최상위(최소) 점수를 결과 리스트에 추가합니다.
     *
     * 결과 반환:
     *
     * 모든 점수를 처리한 후, 결과 리스트를 배열로 변환하여 반환합니다.
     */
    public int[] solution(int k, int[] score) {
        // TODO: k를 잘 생각해서 해당 일자 이전과 이후를 구분해서 풀면 풀 수 있는 문제
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (i < k) {
                priorityQueue.offer(score[i]);
            } else {
                if (score[i] > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(score[i]);
                }
            }

            list.add(priorityQueue.peek());
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        명예의전당 hallOfFame = new 명예의전당();

        int[] firstScore = {10, 100, 20, 150, 1, 100, 200};
        System.out.println("hallOfFame = " + Arrays.toString(hallOfFame.solution(3, firstScore)));

        int[] secondScore = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        // System.out.println("hallOfFame = " + Arrays.toString(hallOfFame.solution(4, secondScore)));
    }
}
