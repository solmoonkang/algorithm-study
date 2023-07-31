package algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class ARunnerWhoFailedToFinish {

    public String solution(String[] participant, String[] completion) {

        String answer = "";

        Map<String, Integer> runner = new HashMap<>();

        // 마라톤에 참여한 선수들의 숫자를 1씩 증가시키고
        for (String participantName : participant) {

            runner.put(participantName, runner.getOrDefault(participantName, 0) + 1);
        }

        // 마라톤에 완주한 선수들의 숫자를 1씩 감소시킨다
        for (String completionName : completion) {

            runner.put(completionName, runner.get(completionName) - 1);
        }

        // 숫자가 감소하지 않은 선수가 완주하지 못한 선수이다
        for (Map.Entry<String, Integer> entry : runner.entrySet()) {

            if (runner.get(entry.getKey()) != 0) {

                answer = entry.getKey();
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] participant = {"leo", "kiki", "eden"};      // 마라톤에 참여한 선수들의 이름이 담긴 배열
        String[] completion = {"eden", "kiki"};       // 마라톤에 완주한 선수들의 이름이 단긴 배열

        ARunnerWhoFailedToFinish failed = new ARunnerWhoFailedToFinish();

        System.out.println("Result : " + failed.solution(participant, completion));
    }
}
