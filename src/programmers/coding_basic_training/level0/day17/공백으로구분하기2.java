package programmers.coding_basic_training.level0.day17;

import java.util.Arrays;

public class 공백으로구분하기2 {

    public String[] solution(String my_string) {

        // my_string 에 나온 단어를 앞에서부터 순서대로 담은 문자열 배열을 반환하라

        String[] answer = my_string.split(" ");

        answer = Arrays.stream(answer)
                .filter(m -> !m.isEmpty())
                .toArray(String[]::new);

        return answer;
    }

    public static void main(String[] args) {

        공백으로구분하기2 blank = new 공백으로구분하기2();

        System.out.println("Result : " + Arrays.toString(blank.solution(" i    love  you")));
        System.out.println("Result : " + Arrays.toString(blank.solution("    programmers  ")));
    }
}
