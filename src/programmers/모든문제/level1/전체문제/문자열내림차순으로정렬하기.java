package programmers.모든문제.level1.전체문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문자열내림차순으로정렬하기 {

    /**
     * [ 문제 설명 ]
     * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
     * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
     */
    public String solution(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            answer.append(list.get(i));
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        문자열내림차순으로정렬하기 sortStringInDescendingOrder = new 문자열내림차순으로정렬하기();
        System.out.println("Result: " + sortStringInDescendingOrder.solution("Zbcdefg"));
    }
}
