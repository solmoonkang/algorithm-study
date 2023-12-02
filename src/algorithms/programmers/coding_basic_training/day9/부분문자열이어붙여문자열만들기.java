package algorithms.programmers.coding_basic_training.day9;

import java.util.ArrayList;
import java.util.List;

public class 부분문자열이어붙여문자열만들기 {

    public String solution(String[] my_strings, int[][] parts) {

        List<String> list = new ArrayList<>();

        // parts[i]는 [s, e] 형태로, my_strings[i]의 인덱스 s 부터 인덱스 e 까지의 부분 문자열을 의미한다
        for (int i = 0; i < parts.length; i++) {

            String str = my_strings[i].substring(parts[i][0], parts[i][1] + 1);

            list.add(str);
        }

        // 각 my_strings 의 원소의 parts 에 해당하는 부분 문자열을 순서대로 이어 붙인 문자열을 반환하라
        String answer = String.join("", list);

        return answer;
    }

    public String solution_others(String[] my_strings, int[][] parts) {

        String answer = "";

        for (int i = 0; i < parts.length; i++) {
            answer += my_strings[i].substring(parts[i][0], parts[i][1] + 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        부분문자열이어붙여문자열만들기 makeStringArray = new 부분문자열이어붙여문자열만들기();

        String[] my_strings = {"progressive", "hamburger", "hammer", "ahocorasick"};
        int[][] parts = {{0, 4}, {1, 2}, {3, 5}, {7, 7}};

        System.out.println("Result : " + makeStringArray.solution(my_strings, parts));
    }
}
