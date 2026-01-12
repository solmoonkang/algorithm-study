package 입문문제.day15;

import java.util.*;

public class 한번만등장한문자 {

    /**
     * [ 문제 설명 ]
     * 문자열 s가 매개변수로 주어집니다. s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 반환하라.
     * 한 번만 등장하는 문자가 없을 경우 빈 문자열을 반환한다.
     */
    public String solution(String s) {
        Map<Character, Integer> hashMap = new TreeMap<>();
        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                builder.append(entry.getKey());
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        한번만등장한문자 uniqueCharacter = new 한번만등장한문자();
        System.out.println("Result: " + uniqueCharacter.solution("abcabcadc"));
        System.out.println("Result: " + uniqueCharacter.solution("abdc"));
        System.out.println("Result: " + uniqueCharacter.solution("hello"));
    }
}
