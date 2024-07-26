package programmers.모든문제.level1.전체문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 자연수뒤집어배열로만들기 {

    /**
     * 자연수 n 을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
     */

    public int[] solution(long n) {
        String s = String.valueOf(n);
        List<Integer> list = new ArrayList<>();

        StringBuilder builder = new StringBuilder(s);
        builder.reverse();

        for (int i = 0; i < builder.length(); i++) {
            char c = builder.charAt(i);
            int answer = Character.getNumericValue(c);
            list.add(answer);
        }
        return list.stream().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
        자연수뒤집어배열로만들기 reverseNumberIntoArray = new 자연수뒤집어배열로만들기();
        System.out.println("Result: " + Arrays.toString(reverseNumberIntoArray.solution(12345)));
    }
}
