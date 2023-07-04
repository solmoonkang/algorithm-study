package codingTest.level0;

import java.util.HashMap;
import java.util.Map;

public class 옹알이 {

    /**
     * 조카가 하는 발음을 String[] pronunciation 에 저장한다면,
     * babbling 에 저장된 발음을 pronunciation 과 비교하여 해당 문자열과 같은 문자열이 있을 경우 숫자로 출력한다
     * 또한, babbling 에 저장된 발음은 각 한 번씩만 등장하기 때문에 HashSet 혹은 HashMap 을 사용한다
     */

    public int solution_hash(String[] babbling) {

        int answer = 0;

        String[] sounds = {"aya", "ye", "woo", "ma"};

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String sound : sounds) {

                hashMap.put(sound, 1);
            }

        for (String s : babbling) {

            if (hashMap.containsKey(s)) {

                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] pronunciation1 = {"aya", "yee", "u", "maa", "wyeoo"};
        String[] pronunciation2 = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        옹알이 babe = new 옹알이();

        System.out.println("Babbling : " + babe.solution_hash(pronunciation1));
        System.out.println("Babbling : " + babe.solution_hash(pronunciation2));
    }
}
