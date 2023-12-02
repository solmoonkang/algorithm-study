package programmers.coding_basic_introduction.day13;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class 중복된문자제거 {

    /**
     * [ 문제 설명 ]
     * 문자열 my_string이 매개변수로 주어집니다. my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 반환하라.
     */
    public String solution(String my_string) {
        Set<Character> set = new LinkedHashSet<>();

        for (char c : my_string.toCharArray()) {
            set.add(c);
        }

        return set.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        중복된문자제거 removeDuplicatedCharacters = new 중복된문자제거();
        System.out.println("Result: " + removeDuplicatedCharacters.solution("people"));
        System.out.println("Result: " + removeDuplicatedCharacters.solution("We are the world"));
    }
}
