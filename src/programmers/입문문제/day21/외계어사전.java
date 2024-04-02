package programmers.입문문제.day21;

import java.util.Arrays;
import java.util.HashSet;

public class 외계어사전 {

    /**
     * [ 문제 설명 ]
     * PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다.
     * 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다.
     * spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 존재하지 않는다면 2를 반환하라.
     */
    public int solution(String[] spell, String[] dic) {
        HashSet<String> spellSet = new HashSet<>(Arrays.asList(spell));
        int answer = 2;
        for (String d : dic) {
            if (d.length() == spell.length) {
                HashSet<String> tempSet = new HashSet<>(spellSet);
                for (char c : d.toCharArray()) {
                    String str = String.valueOf(c);
                    if (!tempSet.contains(str)) {
                        break;
                    } else {
                        tempSet.remove(str);
                    }
                }
                if (tempSet.isEmpty()) {
                    answer = 1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        외계어사전 alienDictionary = new 외계어사전();
        String[] firstSpell = {"p", "o", "s"};
        String[] firstDic = {"sod", "eocd", "qixm", "adio", "soo"};
        String[] secondSpell = {"z", "d", "x"};
        String[] secondDic = {"def", "dww", "dzx", "loveaw"};
        System.out.println("Result: " + alienDictionary.solution(firstSpell, firstDic));
        System.out.println("Result: " + alienDictionary.solution(secondSpell, secondDic));
    }
}
