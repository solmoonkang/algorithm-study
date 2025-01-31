package 모든문제.level1.알고리즘고득점KIT;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class 완주하지못한선수 {

    /**
     * 입력으로 중복된 값을 받았을 때를 생각하지 못하고 문제를 처음 접근했음.
     * Map.Entry로 반복문을 돌아 값을 반환했는데, 스트림 API를 사용하여 반환하는 방식을 사용해 봄.
     */
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantNames = new HashMap<>();

        for (String name : participant) {
            participantNames.put(name, participantNames.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            participantNames.put(name, participantNames.get(name) - 1);
        }

        return participantNames.entrySet().stream()
                .filter(names -> names.getValue() != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        완주하지못한선수 problem = new 완주하지못한선수();

        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        System.out.println("problem = " + problem.solution(participant1, completion1));

        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println("problem = " + problem.solution(participant2, completion2));

        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        System.out.println("problem = " + problem.solution(participant3, completion3));
    }
}
