package programmers.coding_basic_training.level0.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 접미사배열 {

    public String[] solution(String my_string) {

        // 접미사란 어떤 문자열에 대해서 특정 인덱스부터 시작하는 문자열을 의미한다

        // 문자열 my_string 의 모든 접미사를 사전순으로 정렬한 문자열 배열을 반환하라

        // 즉, 문자열을 알파벳 하나하나씩 출력하고, 사전순으로 정렬
        List<String> list = new ArrayList<>();

        for (int i = 0; i < my_string.length(); i++) {

            String str = my_string.substring(i);

            list.add(str);
        }

        String[] answer = list.stream().toArray(String[]::new);

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {

        접미사배열 array = new 접미사배열();

        System.out.println("Result : " + Arrays.toString(array.solution("banana")));
        System.out.println("Result : " + Arrays.toString(array.solution("programmers")));
    }
}
