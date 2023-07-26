package datastructure.map;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

    /**
     * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant 와 완주한 선수들의 이름이 담긴 배열 completion 이 주어질 때,
     * 완주하지 못한 선수의 이름을 반환하도록 한다
     */

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> marathon = new HashMap<>();

        String answer = "";

        // 참가자들의 이름을 HashMap 에 넣어 이름을 Key 로 하여, 동일한 이름의 참가자가 있을 경우, 해당 이름의 참가자 수를 Value 로 증가
        for (String participantName : participant) {

            marathon.put(participantName, marathon.getOrDefault(participantName, 0) + 1);
        }

        // 완주자들의 이름을 순회하면서 HashMap 에서 해당 이름을 찾아서 해당 참가자 수를 감소
        for (String completionName : completion) {

            marathon.put(completionName, marathon.get(completionName) - 1);
        }

        // HashMap 을 순회하면서 Value 가 1인 Key 를 찾아서 반환
        for (String name : marathon.keySet()) {

            if (marathon.get(name) == 1) {

                answer = name;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        완주하지못한선수 failRunner = new 완주하지못한선수();

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println("Runner who fail race : " + failRunner.solution(participant, completion));
    }
}
