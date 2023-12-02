package algorithms.programmers.coding_basic_introduction.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 문자열정렬하기 {

    /**
     * [ 문제 설명 ]
     * 문자열 my_string이 매개변수로 주어질 때, my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 반환하라.
     */
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        String answer = my_string.replaceAll("\\D", "");
        for (int i = 0; i < answer.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(answer.charAt(i))));
        }
        return list.stream().sorted().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
        문자열정렬하기 sortString = new 문자열정렬하기();
        System.out.println("Result: " + Arrays.toString(sortString.solution("hi12392")));
        System.out.println("Result: " + Arrays.toString(sortString.solution("p2o4i8gj2")));
        System.out.println("Result: " + Arrays.toString(sortString.solution("abcde0")));
    }
}
