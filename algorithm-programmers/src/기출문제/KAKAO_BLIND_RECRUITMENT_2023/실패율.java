package 기출문제.KAKAO_BLIND_RECRUITMENT_2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 실패율 {

    /**
     * [ 문제 설명 ]
     * 슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다.
     * 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다.
     * 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
     *
     * 이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다.
     * 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다.
     * 오렐리를 위해 실패율을 구하는 코드를 완성하라.
     *
     * 실패율은 다음과 같이 정의한다.
     * 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
     * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
     * 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
     */

    /**
     * [ 제한 사항 ]
     * 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
     * stages의 길이는 1 이상 200,000 이하이다.
     * stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
     *  - 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
     *  - 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
     * 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
     * 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
     */
    public int[] solution(int N, int[] stages) {
        // TODO: Map의 메서드들에 대해서 처음 알게 된 것들이 많다. 다시 한 번 더 풀어보자. 공부하면 금방 풀 수 있을거 같다.
        // 실패율 = 스테이지에 도달했지만 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        // N = 전체 스테이지의 개수, stages = 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
        // 최종적으로 실패율이 높은 스테이지부터 내림차순으로 반환하라.
        int players = stages.length;
        Map<Integer, Integer> stageToPlayers = new HashMap<>();
        Map<Integer, Double> failureRateMap = new HashMap<>();

        for (int stage : stages) {
            stageToPlayers.put(stage, stageToPlayers.getOrDefault(stage, 0) + 1);
        }

        int remainingPlayers = players;

        for (int i = 1; i <= N; i++) {
            if (stageToPlayers.containsKey(i)) {
                double failRate = (double) stageToPlayers.get(i);
                failureRateMap.put(i, failRate);
                remainingPlayers -= stageToPlayers.get(i);
            } else {
                failureRateMap.put(i, 0.0);
            }
        }

        return failureRateMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static void main(String[] args) {
        실패율 fail = new 실패율();

        int[] firstStages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println("fail = " + Arrays.toString(fail.solution(5, firstStages)));

        int[] secondStages = {4, 4, 4, 4, 4};
        System.out.println("fail = " + Arrays.toString(fail.solution(4, secondStages)));
    }
}
