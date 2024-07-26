package programmers.모든문제.level1.전체문제;

import java.util.*;

public class 달리기경주 {

    /**
     * 제한 사항
     * 5 ≤ players 의 길이 ≤ 50,000
         * players[i]는 i번째 선수의 이름을 의미합니다.
         * players 의 원소들은 알파벳 소문자로만 이루어져 있습니다.
         * players 에는 중복된 값이 들어가 있지 않습니다.
         * 3 ≤ players[i]의 길이 ≤ 10
     * 2 ≤ callings 의 길이 ≤ 1,000,000
         * callings 는 players 의 원소들로만 이루어져 있습니다.
         * 경주 진행중 1등인 선수의 이름은 불리지 않습니다.
     */

    public String[] solution_run(String[] players, String[] callings) {

        // answer 를 players 의 길이만큼 초기화한다
        String[] answer = new String[players.length];

        // players 의 이름과 등수를 담을 HashMap 을 선언한다
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {

            // 등수 순서대로 주어지니 HashMap 에 등수를 담는다
            hashMap.put(players[i], i);
        }

        // callings 길이만큼 반복문을 돌린다
        for (int i = 0; i < callings.length; i++) {

            // 불린 선수의 이름을 통해 해당 등수를 저장한다
            int temp = hashMap.get(callings[i]);

            // 가져온 등수로 players 배열에 접근하여 해당 등수의 선수를 가지고 온다
            String change = players[temp];
            players[temp] = players[temp - 1];
            players[temp - 1] = change;

            // 추월당한 선수와 swap 해주고 HashMap 에서 등수를 갱신해준다
            hashMap.put(change, hashMap.get(change) - 1);
            hashMap.put(players[temp], hashMap.get(players[temp]) + 1);

            answer = players;
        }

        return answer;
    }


    /**
     * [ 문제 설명 ]
     * 얀에서는 매년 달리기 경주가 열립니다. 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.
     * 예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때,
     * 해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다.
     * 즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.
     *
     * 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와
     * 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때,
     * 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 5 ≤ players의 길이 ≤ 50,000
     *  - players[i]는 i번째 선수의 이름을 의미합니다.
     *  - players의 원소들은 알파벳 소문자로만 이루어져 있습니다.
     *  - players에는 중복된 값이 들어가 있지 않습니다.
     *  - 3 ≤ players[i]의 길이 ≤ 10
     * 2 ≤ callings의 길이 ≤ 1,000,000
     *  - callings는 players의 원소들로만 이루어져 있습니다.
     *  - 경주 진행중 1등인 선수의 이름은 불리지 않습니다.
     */
    public String[] solution2(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int index = map.get(callings[i]);

            String change = players[index];
            players[index] = players[index - 1];
            players[index - 1] = change;

            map.put(change, map.get(change) - 1);
            map.put(players[index], map.get(players[index]) + 1);

            answer = players;
        }

        return answer;
    }


    public static void main(String[] args) {
        달리기경주 race = new 달리기경주();

        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println("race = " + Arrays.toString(race.solution2(players, callings)));
    }
}
