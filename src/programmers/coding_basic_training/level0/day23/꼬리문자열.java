package programmers.coding_basic_training.level0.day23;

import java.util.Arrays;

public class 꼬리문자열 {

    public String solution(String[] str_list, String ex) {

        // 문자열들이 담긴 리스트가 주어졌을 때, 모든 문자열들을 순서대로 합친 문자열을 꼬리 문자열이라고 한다
        // 꼬리 문자열을 만들 때, 특정 문자열을 포함한 문자열은 제외시키려고 한다
        // str_list에서 ex를 포함한 문자열을 제외하고 만든 꼬리 문자열을 반환하라

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str_list.length; i++) {

            if (!str_list[i].contains(ex)) {

                stringBuilder.append(str_list[i]);

            }

        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        꼬리문자열 tail = new 꼬리문자열();

        String[] str_list1 = {"abc", "def", "ghi"};
        String[] str_list2 = {"abc", "bbc", "cbc"};

        System.out.println("Result : " + tail.solution(str_list1, "ef"));
        System.out.println("Result : " + tail.solution(str_list2, "c"));
    }
}
