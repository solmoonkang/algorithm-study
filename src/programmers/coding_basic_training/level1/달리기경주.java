package programmers.coding_basic_training.level1;

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

    public static void main(String[] args) {

        String[] player = {"mumu", "soe", "poe", "kai", "mine"};
        String[] call = {"kai", "kai", "mine", "mine"};

        달리기경주 run = new 달리기경주();

        System.out.println(Arrays.toString(run.solution_run(player, call)));
    }
}
