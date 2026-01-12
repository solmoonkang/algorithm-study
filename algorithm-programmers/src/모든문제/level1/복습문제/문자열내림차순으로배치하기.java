package 모든문제.level1.복습문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문자열내림차순으로배치하기 {

    public String solution(String s) {
        List<Character> stringSortList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            stringSortList.add(c);
        }

        Collections.sort(stringSortList);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            builder.append(stringSortList.get(i));
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        문자열내림차순으로배치하기 problem = new 문자열내림차순으로배치하기();

        System.out.println("problem = " + problem.solution("Zbcdefg"));
    }
}
