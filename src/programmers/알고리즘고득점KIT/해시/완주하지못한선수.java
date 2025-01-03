package programmers.알고리즘고득점KIT.해시;

import java.util.*;
import java.util.stream.Collectors;

public class 완주하지못한선수 {

    // 이러면 동명이인을 고려하지 못한다.
    public String solutionBySet(String[] participant, String[] completion) {
        Set<String> completionMarathonRunnersSet = new HashSet<>(Arrays.asList(completion));

        String nonFinishers = "";
        for (String runner : participant) {
            if (!completionMarathonRunnersSet.contains(runner)) nonFinishers = runner;
        }

        return nonFinishers;
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMarathonMap = new HashMap<>();

        for (String runners : participant)
            participantMarathonMap.put(runners, participantMarathonMap.getOrDefault(runners, 0) + 1);

        for (String runners : completion)
            participantMarathonMap.put(runners, participantMarathonMap.get(runners) - 1);

        return participantMarathonMap.entrySet().stream()
                .filter(runners -> runners.getValue() > 0)
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
