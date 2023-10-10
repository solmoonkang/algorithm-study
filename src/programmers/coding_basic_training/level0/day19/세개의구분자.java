package programmers.coding_basic_training.level0.day19;

import java.util.ArrayList;
import java.util.Arrays;

public class 세개의구분자 {

    public String[] solution(String myStr) {

        // 임의의 문자열이 주어졌을 때 문자 "a", "b", "c"를 구분자로 사용해 문자열을 나누고자 합니다.
        // 예를 들어 주어진 문자열이 "baconlettucetomato"라면 나눠진 문자열 목록은 ["onlettu", "etom", "to"] 가 됩니다.
        // 문자열 myStr 이 주어졌을 때 위 예시와 같이 "a", "b", "c"를 사용해 나눠진 문자열을 순서대로 저장한 배열을 반환하라
        // ( 단, 두 구분자 사이에 다른 문자가 없을 경우에는 아무것도 저장하지 않으며, 반환할 배열이 빈 배열이라면 ["EMPTY"]를 반환하라 )

        String[] answer = myStr.split("[abc]");

        answer = Arrays.stream(answer)
                .filter(o -> !o.isEmpty())
                .toArray(String[]::new);

        ArrayList<String> list = new ArrayList<>();

        for (String a : answer) {

            list.add(a);
        }

        if (list.isEmpty()) {

            return new String[]{"EMPTY"};

        }

        return answer;
    }

    public String[] others(String myStr) {

        String[] str = Arrays.stream(myStr.split("[abc]"))
                .filter(o -> !o.isEmpty())
                .toArray(String[]::new);

        return str.length == 0 ? new String[] { "EMPTY" } : str;

    }

    public static void main(String[] args) {

        세개의구분자 three = new 세개의구분자();

        System.out.println("Result : " + Arrays.toString(three.solution("baconlettucetomato")));
        System.out.println("Result : " + Arrays.toString(three.solution("abcd")));
        System.out.println("Result : " + Arrays.toString(three.solution("cabab")));

        System.out.println("Result : " + Arrays.toString(three.others("baconlettucetomato")));
    }
}
