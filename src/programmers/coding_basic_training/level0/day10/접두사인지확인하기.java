package programmers.coding_basic_training.level0.day10;

import java.util.ArrayList;

public class 접두사인지확인하기 {

    public int solution(String my_string, String is_prefix) {

        // 접두사란 특정 인덱스까지의 문자열을 의미한다
        // is_perfix 가 my_string 의 접두사라면 1을, 아니면 0을 반환하라

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < my_string.length(); i++) {

            String prefix = my_string.substring(0, i + 1);

            list.add(prefix);
        }

        return list.contains(is_prefix) ? 1 : 0;
    }

    public int others(String my_string, String is_prefix) {

        if (my_string.startsWith(is_prefix)) return 1;

        return 0;
    }

    public static void main(String[] args) {

        접두사인지확인하기 confirm = new 접두사인지확인하기();

        System.out.println("Result : " + confirm.solution("banana", "ban"));
        System.out.println("Result : " + confirm.solution("banana", "nan"));
        System.out.println("Result : " + confirm.solution("banana", "abcd"));
        System.out.println("Result : " + confirm.solution("banana", "bananan"));


        System.out.println("Others Solution");
        System.out.println("Result : " + confirm.others("banana", "ban"));
        System.out.println("Result : " + confirm.others("banana", "nan"));
    }
}
