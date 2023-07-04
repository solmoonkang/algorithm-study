package dataStructure.map.hashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 완주하지못한선수 {

    /**
     * 문제 설명
     * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
     * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant 와 완주한 선수들의 이름이 담긴 배열 completion 이 주어질 때,
     * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한 사항
     * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
     * completion 의 길이는 participant 의 길이보다 1 작습니다.
     * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
     * 참가자 중에는 동명이인이 있을 수 있습니다.
     */

    /**
     * 문제 접근 방식 : 문제를 간단하게 만들어보기
     * participant 는 N 명의 이름이 들어있고, completion 는 N-1 명의 이름이 들어있다
     * 즉, participant 와 completion 을 서로 비교하여 동일하지 않은 이름을 골라내면 된다
     */

    public String solution_sort(String[] participant, String[] completion) {

        // 두 배열을 정렬한다
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 두 배열이 다를 때까지 찾는다
        int i = 0;

        for (i = 0; i < completion.length; i++) {

            if (!participant[i].equals(completion[i])) {
                break;
            }
        }

        // 마지막 주자가 완주하지 못했을 경우로 완주하지 못한 선수의 이름을 반환한다
        return participant[i];
    }

    public String solution_hash(String[] participant, String[] completion) {

        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String player : participant) {

            // 중복 체크를 위해 getOrDefault 를 사용
            hashMap.put(player, hashMap.getOrDefault(player, 0) + 1);
        }

        for (String player : completion) {

            hashMap.put(player, hashMap.get(player) - 1);
        }

        Iterator<Map.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();

        while (iterator.hasNext()){

            Map.Entry<String, Integer> entry = iterator.next();

            if (entry.getValue() != 0) {

                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        String[] part1 = {"leo", "kiki", "eden"};
        String[] part2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] part3 = {"mislav", "stanko", "mislav", "ana"};

        String[] comp1 = {"eden", "kiki"};
        String[] comp2 = {"marina", "josipa", "nikola", "vinko"};
        String[] comp3 = {"mislav", "stanko", "ana"};

        완주하지못한선수 race = new 완주하지못한선수();

//        System.out.println(race.solution_sort(part, comp));
//        System.out.println("----------------------------");

        System.out.println(race.solution_hash(part1, comp1));
        System.out.println("----------------------------");
        System.out.println(race.solution_hash(part2, comp2));
        System.out.println("----------------------------");
        System.out.println(race.solution_hash(part3, comp3));
    }
}
