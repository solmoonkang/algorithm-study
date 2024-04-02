package programmers.입문문제.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배열원소의길이 {

    /**
     * [ 문제 설명 ]
     * 문자열 배열 strlist가 매개변수로 주어집니다. strlist 각 원소의 길이를 담은 배열을 반환하라.
     */
    public int[] solution(String[] strlist) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < strlist.length; i++) {
            String s = strlist[i];
            list.add(s.length());
        }
        return list.stream().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
        배열원소의길이 lengthOfAnArrayElement = new 배열원소의길이();
        String[] firstStrList = {"We", "are", "the", "world!"};
        String[] secondStrList = {"I", "Love", "Programmers."};
        System.out.println("Result: " + Arrays.toString(lengthOfAnArrayElement.solution(firstStrList)));
        System.out.println("Result: " + Arrays.toString(lengthOfAnArrayElement.solution(secondStrList)));
    }
}
